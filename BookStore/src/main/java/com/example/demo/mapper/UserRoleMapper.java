package com.example.demo.mapper;

import com.example.demo.beans.Role;
import com.example.demo.beans.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper  implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("id");
        int role_id = rs.getInt("role_id");
        return new UserRole(id,role_id);

    }
}
