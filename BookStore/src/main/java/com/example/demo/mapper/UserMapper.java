package com.example.demo.mapper;

import com.example.demo.beans.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for User objects
    used to map result sets to
    User objects
*/


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("id");
        int address_id = rs.getInt("address");
        String fname = rs.getString("fname");
        String lname = rs.getString("lname");
        String username = rs.getString("username");
        String pw = rs.getString("pw");
        String role = rs.getString("role");

        return new User(id,address_id,fname,lname,username,pw, role);

    }
}
