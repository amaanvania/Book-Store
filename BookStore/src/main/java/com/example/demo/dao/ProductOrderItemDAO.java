package com.example.demo.dao;

import com.example.demo.beans.ProductOrderItem;
import com.example.demo.mapper.ProductOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductOrderItemDAO {

    @Autowired
    JdbcTemplate jdbc;

    public List<ProductOrderItem> getAllProductOrderItems()
    {
        String query = "SELECT * FROM `4413`.POItem;";
        return jdbc.query(query, new ProductOrderItemMapper());

    }


    public ProductOrderItem getProductOrderItem(int id)
    {
        String query = "SELECT * FROM `4413`.POItem where id='"+id+"';";

        List<ProductOrderItem> list =  jdbc.query(query, new ProductOrderItemMapper());
        if(list.size() == 0) return null;
        return list.get(0);
    }



    public void insertProductOrderItem(ProductOrderItem productOrder) throws SQLException {
        String strSelect  = "INSERT INTO POItem (id, bid, quantity,po_id) VALUES (?, ?, ?,?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        preparedStatement.setInt(1, productOrder.getId());
        preparedStatement.setString(2, productOrder.getBook_id());
        preparedStatement.setInt(3, productOrder.getQuantity());
        preparedStatement.setInt(4, productOrder.getPo_id());
        preparedStatement.executeUpdate();

    }

    public void removeProductOrderItem(int productOrderId) throws SQLException {
        String query = "DELETE FROM POItem WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);
        preparedStatement.execute();
    }
}
