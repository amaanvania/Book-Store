package com.example.demo.mapper;

import com.example.demo.beans.MonthBookSale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Mapper for MonthBook objects
    used to map result sets to
    MonthBook objects
*/



public class MonthBookMapper implements RowMapper<MonthBookSale> {
    @Override
    public MonthBookSale mapRow(ResultSet rs, int rowNum) throws SQLException {
        MonthBookSale result = new MonthBookSale();

        result.setBid(rs.getString("bid"));
        result.setTitle(rs.getString("title"));
        result.setPrice(rs.getDouble("price"));
        result.setAmount_sold(rs.getInt("amount_sold"));
        result.setMonthly_sales(rs.getDouble("monthly_sales"));

        return result;
    }
}
