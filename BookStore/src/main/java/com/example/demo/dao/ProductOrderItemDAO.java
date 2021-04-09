package com.example.demo.dao;

import com.example.demo.beans.MonthBookSale;
import com.example.demo.beans.ProductOrderItem;
import com.example.demo.beans.TopBook;
import com.example.demo.mapper.MonthBookMapper;
import com.example.demo.mapper.ProductOrderItemMapper;
import com.example.demo.mapper.TopBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/*
    DAO class for Order Item objects
    used to get/insert/update/delete
    into/from database
*/
@Repository
public class ProductOrderItemDAO {

    @Autowired
    JdbcTemplate jdbc;


    @Transactional
    public List<ProductOrderItem> getAllProductOrderItems()
    {
        String query = "SELECT * FROM `4413`.POItem;";
        return jdbc.query(query, new ProductOrderItemMapper());

    }

    @Transactional
    public ProductOrderItem getProductOrderItem(int id)
    {
        String query = "SELECT * FROM `4413`.POItem where id = ?;";

        List<ProductOrderItem> list =  jdbc.query(query, ps -> ps.setInt(1, id), new ProductOrderItemMapper());
        if(list.size() == 0) return null;
        return list.get(0);
    }

    @Transactional
    public List<ProductOrderItem> getProductOrderItem(String bid)
    {
        String query = "SELECT * FROM `4413`.POItem where bid = ?;";

        List<ProductOrderItem> list =  jdbc.query(query, ps -> ps.setString(1, bid), new ProductOrderItemMapper());
        return list;
    }


    @Transactional
    public List<TopBook> getTopTenSoldBooks(){
        String query = "SELECT b.bid, b.title, SUM(o1.quantity) as quantity, b.price, CAST(b.price * SUM(o1.quantity) AS DECIMAL(7,2)) as revenue \n" +
                "FROM `4413`.POItem o1 join `4413`.book b on o1.bid = b.bid\n" +
                "GROUP BY o1.bid \n" +
                "ORDER BY SUM(o1.quantity) DESC LIMIT 10;";
        List<TopBook> list =  jdbc.query(query, new TopBookMapper());
        if(list.size() == 0) return null;
        return list;

    }
    @Transactional
    public List<MonthBookSale> getSortedBooksByMonth(int month, int year) throws SQLException {
        String query = "SELECT item.bid, b.title, b.price, sum(item.quantity) as amount_sold, CAST(b.price * SUM(item.quantity) AS DECIMAL(7,2)) as monthly_sales\n" +
                "from `4413`.POItem item join `4413`.PO p on item.po_id = p.id\n" +
                "join `4413`.book b on item.bid = b.bid\n" +
                "where MONTH(p.date_time) = ? and YEAR(p.date_time) = ? \n" +
                "group by item.bid";


        List<MonthBookSale> list =  jdbc.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,month);
                ps.setInt(2,year);
            }
        }, new MonthBookMapper());
        return list;

    }



    @Transactional
    public void insertProductOrderItem(ProductOrderItem productOrder) throws SQLException {
        String strSelect  = "INSERT INTO POItem (bid, quantity,po_id) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        //preparedStatement.setInt(1, productOrder.getId());
        preparedStatement.setString(1, productOrder.getBook_id());
        preparedStatement.setInt(2, productOrder.getQuantity());
        preparedStatement.setInt(3, productOrder.getPo_id());
        preparedStatement.executeUpdate();

    }

    @Transactional
    public void removeProductOrderItem(int productOrderId) throws SQLException {
        String query = "DELETE FROM POItem WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);
        preparedStatement.execute();
    }
}
