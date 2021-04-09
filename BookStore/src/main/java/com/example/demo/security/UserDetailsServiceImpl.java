package com.example.demo.security;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
    Class used to help authenticate admins
*/
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO ud;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        System.out.println(s);
        try {
            user = ud.getUser(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(user == null) throw new UsernameNotFoundException("User not found");

        return new MyUserDetails(user);
    }
}
