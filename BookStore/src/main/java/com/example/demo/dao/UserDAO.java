package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.beans.Role;
import com.example.demo.beans.UserRole;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Book;
import com.example.demo.beans.User;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.UserMapper;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbc;
	
	public User getUser(String username) throws Exception
	{
		String query = "SELECT * FROM `4413`.user where username='"+username+"';";
		List<User> users =  jdbc.query(query, new UserMapper());
		if(users.size() == 0) return null;
		return users.get(0);
	}

	public boolean userExists(String username){
		String query = "SELECT * FROM `4413`.user where username='"+username+"';";
		List<User> users =  jdbc.query(query, new UserMapper());
		return users.size() > 0;
	}

/*	public String getRole(String username) throws Exception {
		User curr = getUser(username);
		if(curr == null) throw new Exception("User doesn't exist");

		System.out.println("ID is " + curr.getId());

		String query = "SELECT * FROM `4413`.User_Roles where id='"+curr.getId()+"';";
		List<UserRole> users =  jdbc.query(query, new UserRoleMapper());
		if(users.size() == 0) return "USER";
		int role = users.get(0).getRole_id();

		System.out.println("Role is: " + role);
		String nextQuery = "SELECT * FROM `4413`.Roles where id='"+role+"';";
		List<Role> roles = jdbc.query(nextQuery, new RoleMapper());
		if(roles.size() == 0) return "USER";

		System.out.println("getRole here" + roles.get(0).getName());
		return roles.get(0).getName();

	}*/

	public String getRole(){
		return "ADMIN";
	}

	public int insert(User user) throws SQLException {
		String strSelect  = "INSERT INTO user (address,fname,lname,username,pw) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
		preparedStatement.setInt(1, user.getAddress());
		preparedStatement.setString(2, user.getFname());
		preparedStatement.setString(3, user.getLname());
		preparedStatement.setString(4, user.getUsername());
		preparedStatement.setString(5, user.getPassword());

		int response =  preparedStatement.executeUpdate();
		System.out.println(response);
		return response;
	} 
	
}
