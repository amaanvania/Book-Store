package com.example.demo.mapper;

import com.example.demo.beans.TopBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for TopBook objects
    used to map result sets to
    TopBook objects
*/


public class TopBookMapper implements RowMapper<TopBook> {
    @Override
    public TopBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        TopBook result = new TopBook();
        result.setBid(rs.getString(1));
        result.setTitle(rs.getString(2));
        result.setQuantity(rs.getInt(3));
        result.setPrice(rs.getDouble(4));
        result.setRevenue(rs.getDouble(5));
        return result;
    }
}
