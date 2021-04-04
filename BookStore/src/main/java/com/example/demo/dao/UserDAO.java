package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	
	public int insert(User user) throws SQLException {
		String strSelect  = "INSERT INTO user (address,fname,lname,username,pw) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
		preparedStatement.setInt(1, user.getAddress());
		preparedStatement.setString(2, user.getFname());
		preparedStatement.setString(3, user.getLname());
		preparedStatement.setString(4, user.getUsername());
		preparedStatement.setString(5, user.getPassword());

		int response =  preparedStatement.executeUpdate();
		return response;
	} 
	
}
