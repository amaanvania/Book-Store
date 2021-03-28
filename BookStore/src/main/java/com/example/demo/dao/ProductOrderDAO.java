package com.example.demo.dao;

import com.example.demo.beans.ProductOrder;
import com.example.demo.mapper.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductOrderDAO {

    @Autowired
    JdbcTemplate jdbc;

    public List<ProductOrder> getAllProductOrders()
    {
        String query = "SELECT * FROM `4413`.PO;";
        return jdbc.query(query, new ProductOrderMapper());

    }


    public ProductOrder getProductOrder(int id)
    {
        String query = "SELECT * FROM `4413`.PO where id='"+id+"';";
        return jdbc.queryForObject(query, new ProductOrderMapper());
    }



    public void insertProductOrder(ProductOrder productOrder) throws SQLException {
        String strSelect  = "INSERT INTO PO (id, status, user_id) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        preparedStatement.setInt(1, productOrder.getId());
        preparedStatement.setString(2, productOrder.getStatus());
        preparedStatement.setInt(3, productOrder.getUser_id());
        preparedStatement.executeUpdate();

    }

    public void removeProductOrder(int productOrderId) throws SQLException {
        String query = "DELETE FROM PO WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);
        preparedStatement.execute();
    }
}
