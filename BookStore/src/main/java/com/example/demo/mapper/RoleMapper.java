package com.example.demo.mapper;

import com.example.demo.beans.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for Role objects
    used to map result sets to
    Role objects
*/


public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Role(rs.getInt(1),rs.getString(2));
    }
}
