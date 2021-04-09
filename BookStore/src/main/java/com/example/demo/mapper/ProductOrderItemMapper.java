package com.example.demo.mapper;

import com.example.demo.beans.ProductOrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Mapper for ProductOrderItem objects
    used to map result sets to
    ProductOrderItem objects
*/


public class ProductOrderItemMapper implements RowMapper<ProductOrderItem> {

@Override
public ProductOrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        ProductOrderItem p = new ProductOrderItem();
        p.setId(rs.getInt("id"));
        p.setBook_id(rs.getString("bid"));
        p.setPo_id(rs.getInt("po_id"));
        p.setQuantity(rs.getInt("quantity"));

        return p;
    }
}
