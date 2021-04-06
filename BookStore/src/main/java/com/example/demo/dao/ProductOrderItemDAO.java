package com.example.demo.dao;

import com.example.demo.beans.ProductOrderItem;
import com.example.demo.mapper.ProductOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<ProductOrderItem> getTopTenSoldBooks(){
        String query = "SELECT o1.bid, SUM(o1.quantity) FROM `4413`.POItem o1 GROUP BY o1.bid ORDER BY SUM(o1.quantity) DESC LIMIT 10;";
        List<ProductOrderItem> list =  jdbc.query(query, new ProductOrderItemMapper());
        if(list.size() == 0) return null;
        return list;

    }

    public List<ProductOrderItem> getSortedBooksByMonth(int month, int year) throws SQLException {
        String query = "SELECT o1.bid, SUM(o1.quantity) " +
                "FROM `4413`.POItem o1 join `4413`.PO p1 " +
                "where o1.po_id = p1.id and month(p1.date_time) = ? and year(p1.date_time) = ?" +
                "GROUP BY o1.bid " +
                "ORDER BY SUM(o1.quantity) " +
                "DESC LIMIT 10;";

        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);

        preparedStatement.setInt(1,month);

        List<ProductOrderItem> items = new ArrayList<>();
        ProductOrderItemMapper p = new ProductOrderItemMapper();
        ResultSet results = preparedStatement.executeQuery();
        int row = 0;
        while(results.next())
            items.add(p.mapRow(results,++row));

        return items;


    }



    public void insertProductOrderItem(ProductOrderItem productOrder) throws SQLException {
        String strSelect  = "INSERT INTO POItem (bid, quantity,po_id) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        //preparedStatement.setInt(1, productOrder.getId());
        preparedStatement.setString(1, productOrder.getBook_id());
        preparedStatement.setInt(2, productOrder.getQuantity());
        preparedStatement.setInt(3, productOrder.getPo_id());
        preparedStatement.executeUpdate();

    }

    public void removeProductOrderItem(int productOrderId) throws SQLException {
        String query = "DELETE FROM POItem WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);
        preparedStatement.execute();
    }
}
