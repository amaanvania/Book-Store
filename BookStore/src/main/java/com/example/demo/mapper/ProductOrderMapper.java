package com.example.demo.mapper;

import com.example.demo.beans.ProductOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Mapper for ProductOrder objects
    used to map result sets to
    ProductOrder objects
*/

public class ProductOrderMapper implements RowMapper<ProductOrder> {

    @Override
    public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        ProductOrder p = new ProductOrder();
        p.setId(rs.getInt("id"));
        p.setStatus(rs.getString("status"));
        p.setUser_id(rs.getInt("user_id"));
        p.setDate_time(rs.getTimestamp("date_time"));
        p.setTotal_price(rs.getDouble("total_price"));
        return p;
    }
}
