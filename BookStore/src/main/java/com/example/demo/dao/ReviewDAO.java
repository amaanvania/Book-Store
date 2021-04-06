package com.example.demo.dao;

import com.example.demo.beans.Review;
import com.example.demo.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ReviewDAO {

    @Autowired
    JdbcTemplate jdbc;

    public List<Review> getAllReviews()
    {
        String query = "SELECT * FROM `4413`.Review;";
        return jdbc.query(query, new ReviewMapper());

    }


    public Review getReview(int id)
    {
        String query = "SELECT * FROM `4413`.Review where id='"+id+"';";

        List<Review> list = jdbc.query(query, new ReviewMapper());
        if(list.size() == 0) return null;
        return list.get(0);
    }



    public boolean insertReview(Review productOrder) throws SQLException {
        String strSelect  = "INSERT INTO Review (review_id, book_id, review, rating, user_id, date_time) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        preparedStatement.setInt(1, productOrder.getReview_id());
        preparedStatement.setString(2, productOrder.getBook_id());
        preparedStatement.setString(3, productOrder.getReview());
        preparedStatement.setDouble(4, productOrder.getRating());
        preparedStatement.setInt(5, productOrder.getUser_id());
        preparedStatement.setTimestamp(6, productOrder.getDate_time());
        return preparedStatement.execute();

    }

    public boolean removeReview(int productOrderId) throws SQLException {
        String query = "DELETE FROM Review WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);

        return preparedStatement.execute();

    }
}
