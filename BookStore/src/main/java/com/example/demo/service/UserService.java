package com.example.demo.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDAO ud;
	@Autowired
	AddressDAO ad;
	public UserAddress getUserInfo(String username)
	{
		User u = null;
		try {
			u = ud.getUser(username);
			u.setPassword(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new UserAddress(u,ad.getAddress(u.getAddress()));
	}
	
	
	public String registerUser(UserAddress holder)
	{
		User u = holder.getUser();
		Address userAddress = holder.getAddress();
		boolean alreadyExists = true;
		int addressIndex = 0;
		try {
			ud.getUser(u.getUsername());
		}
		catch(Exception e)
		{
			alreadyExists = false;
		}
		
		try {
			addressIndex = ad.insertAddress(userAddress);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Address insert error";
		}
		
		u.setAddress(addressIndex);
		
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
