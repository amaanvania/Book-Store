package com.example.demo.service;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


/*
    Service Class used to provide
    services and functionality
    for User
*/


@Service
public class UserService {
    @Autowired
    UserDAO ud;
    @Autowired
    AddressDAO ad;

    @Autowired
    PasswordEncoder pe;


    //convert user into useraddress
    public UserAddress getUserInfo(String username) {
        User u = null;
        try {
            u = ud.getUser(username);
            u.setPassword(null);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new UserAddress(u, ad.getAddress(u.getAddress()));
    }


    //register a new user
    public String registerUser(UserAddress holder) {
        User u = holder.getUser();

       // System.out.println("REGISTERING HERE");

        Address userAddress = holder.getAddress();
        boolean alreadyExists = true;
        int addressIndex = 0;
        if (ud.userExists(u.getUsername())) return "User already exists";

        try {
            addressIndex = ad.insertAddress(userAddress);
            System.out.println("Address at: " + addressIndex);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            return "Address insert error";
        }

        u.setAddress(addressIndex);


        int result = 0;
        try {
        	System.out.println("Inserting user");
            String password = u.getPassword();
            String encodedPassword = pe.encode(password);
        	u.setPassword(encodedPassword);
            result = ud.insert(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != 0) {
            return "Created";
        }

        return "Unable to Create Account";
    }


    //login an existing user
    //checks password against encrypted
    public String login(User u) {
        User retrievedUser = null;
        try {
            retrievedUser = ud.getUser(u.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            return "invalid username";
        }

        if(retrievedUser == null) return "invalid username";
        if(pe.matches(u.getPassword(),retrievedUser.getPassword())) return "logged in";

       // if (u.getPassword().equals(retrievedUser.getPassword())) {
      //     return "logged in";
      //  }
        return "invalid password";
    }


}
