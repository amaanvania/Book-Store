package com.example.demo.dao;

import com.example.demo.beans.ProductOrder;
import com.example.demo.mapper.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/*
    DAO class for Order objects
    used to get/insert/update/delete
    into/from database
*/
@Repository
public class ProductOrderDAO {

    @Autowired
    JdbcTemplate jdbc;


    @Transactional
    public List<ProductOrder> getAllProductOrders()
    {

        String query = "SELECT * FROM `4413`.PO;";
        return jdbc.query(query, new ProductOrderMapper());


    }


    @Transactional
    public ProductOrder getProductOrder(int id)
    {
        String query = "SELECT * FROM `4413`.PO where id = ?;";
        List<ProductOrder> products = jdbc.query(query, ps -> ps.setInt(1, id), new ProductOrderMapper());
        if(products.size() == 0) return null;
        return products.get(0);
    }


    @Transactional
    public List<ProductOrder> getProductsUnderUser(int id){
        String query = "SELECT * FROM `4413`.PO where user_id = ?;";
        List<ProductOrder> products = jdbc.query(query, ps -> ps.setInt(1, id), new ProductOrderMapper());
        return products;
    }

    @Transactional
    public int insertProductOrder(ProductOrder productOrder) throws SQLException {
        String strSelect  = "INSERT INTO PO (status, user_id, date_time, total_price) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
       // preparedStatement.setInt(1, productOrder.getId());
        preparedStatement.setString(1, productOrder.getStatus());
        preparedStatement.setInt(2, productOrder.getUser_id());
        preparedStatement.setTimestamp(3, productOrder.getDate_time());
        preparedStatement.setDouble(4,productOrder.getTotal_price());
        int response = preparedStatement.executeUpdate();
        if (response != 0)
		{
			return jdbc.queryForObject("SELECT COUNT(*) FROM `4413`.PO", Integer.class);
		}
        return response;
    }


    @Transactional
    public void removeProductOrder(int productOrderId) throws SQLException {
        String query = "DELETE FROM PO WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);
        preparedStatement.execute();
    }
}
