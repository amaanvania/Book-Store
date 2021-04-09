package com.example.demo.dao;

import com.example.demo.beans.AnnomizedReport;
import com.example.demo.beans.User;
import com.example.demo.mapper.AnnomizedReportMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
    DAO class for User objects
    used to get/insert/update/delete
    into/from database
*/


@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbc;

	@Transactional
	public User getUser(String username) throws Exception
	{
		String query = "SELECT * FROM `4413`.user where username= ?;";
		List<User> users  = jdbc.query(query, ps -> ps.setString(1, username), new UserMapper());
		if(users.size() == 0) return null;
		return users.get(0);
	}

	@Transactional
	public boolean userExists(String username){
		String query = "SELECT * FROM `4413`.user where username= ?;";
		List<User> users  = jdbc.query(query, ps -> ps.setString(1, username), new UserMapper());
		return users.size() > 0;
	}


	@Transactional
	public List<AnnomizedReport> getUserReport(){
		String query = "SELECT u.username, sum(p.total_price) as total_amount, a.zip FROM `4413`.PO p\n" +
				"join `4413`.user u on u.id = p.user_id\n" +
				"join `4413`.Address a on u.address = a.id\n" +
				"group by u.id;";

		List<AnnomizedReport> report = jdbc.query(query, new AnnomizedReportMapper());

		return report;

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

	@Transactional
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
