package com.example.demo.service;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    UserDAO ud;
    @Autowired
    AddressDAO ad;

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


    public String registerUser(UserAddress holder) {
        User u = holder.getUser();
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
            result = ud.insert(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != 0) {
            return "Created";
        }

        return "Unable to Create Account";
    }

    public String login(User u) {
        User retrievedUser = null;
        try {
            retrievedUser = ud.getUser(u.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            return "invalid username";
        }

        if (u.getPassword().equals(retrievedUser.getPassword())) {
            return "logged in";
        }
        return "invalid password";
    }


}
