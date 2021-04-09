package com.example.demo.dao;

import com.example.demo.beans.Review;
import com.example.demo.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
    DAO class for book review objects
    used to get/insert/update/delete
    into/from database
*/

@Repository
public class ReviewDAO {

    @Autowired
    JdbcTemplate jdbc;


    @Transactional
    public List<Review> getAllReviews()
    {
        String query = "SELECT r.review_id, r.book_id, r.review, r.rating, r.user_id, r.date_time, u.fname, u.lname\n" +
                "FROM `4413`.Review r join `4413`.user u on r.user_id = u.id;";
        return jdbc.query(query, new ReviewMapper());

    }

    @Transactional
    public Review getReview(int id)
    {
        String query = "SELECT r.review_id, r.book_id, r.review, r.rating, r.user_id, r.date_time, u.fname, u.lname\n" +
                "FROM `4413`.Review r join `4413`.user u on r.user_id = u.id where r.review_id = ?;";

        List<Review> list = jdbc.query(query, ps -> ps.setInt(1, id), new ReviewMapper());
        if(list.size() == 0) return null;
        return list.get(0);
    }
    @Transactional
    public List<Review> getReviewsUnderBook(String bid){
        String query = "SELECT r.review_id, r.book_id, r.review, r.rating, r.user_id, r.date_time, u.fname, u.lname\n" +
                "FROM `4413`.Review r join `4413`.user u on r.user_id = u.id where r.book_id = ?;";
        return jdbc.query(query, ps -> ps.setString(1, bid), new ReviewMapper());
    }

    @Transactional
    public void updateReview(int reviewID, Review newReview) throws SQLException {
        if(reviewID != newReview.getReview_id()) return;


        String query = "UPDATE `4413`.`Review` SET `review` = ?, `rating` = ?, `date_time` = ? WHERE (`id` = ?);";


        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setString(1,newReview.getReview());
        preparedStatement.setDouble(2, newReview.getRating());
        preparedStatement.setTimestamp(3,newReview.getDate_time());
        preparedStatement.executeUpdate();


    }

    @Transactional
    public boolean insertReview(Review productOrder) throws SQLException {
        String strSelect  = "INSERT INTO Review (book_id, review, rating, user_id, date_time) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        preparedStatement.setString(1, productOrder.getBook_id());
        preparedStatement.setString(2, productOrder.getReview());
        preparedStatement.setDouble(3, productOrder.getRating());
        preparedStatement.setInt(4, productOrder.getUser_id());
        preparedStatement.setTimestamp(5, productOrder.getDate_time());
        return preparedStatement.execute();

    }

    @Transactional
    public boolean removeReview(int productOrderId) throws SQLException {
        String query = "DELETE FROM Review WHERE (`id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productOrderId);

        return preparedStatement.execute();

    }
}
