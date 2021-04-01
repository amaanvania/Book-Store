package com.example.demo.service;

import java.sql.SQLException;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDAO ud;
	
	public User getUserInfo(String username)
	{
		User u = null;
		try {
			u = ud.getUser(username);
			u.setPassword(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return u;
	}
	
	
	public String registerUser(User u)
	{
		boolean alreadyExists = true;
		try {
			ud.getUser(u.getUsername());
		}
		catch(Exception e)
		{
			alreadyExists = false;
		}
		if (alreadyExists == false) // create account
		{
			int result = 0;
			try {
				result = ud.insert(u);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result != 0) 
			{
				return "Created";
			}
		}
		return "Unable to Create Account";
	}
	
	public String login(User u)
	{
		User retrievedUser = null;
		try {
			retrievedUser = ud.getUser(u.getUsername());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "invalid username";
		}
		
		if (u.getPassword().equals(retrievedUser.getPassword()))
		{
			return "logged in";
		}
		return "invalid password";
	}
	
	
}
