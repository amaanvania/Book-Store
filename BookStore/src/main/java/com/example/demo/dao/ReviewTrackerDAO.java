package com.example.demo.dao;

import com.example.demo.beans.BookReviewTracker;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.mapper.BookReviewTrackerMapper;
import com.example.demo.mapper.ReviewTrackerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReviewTrackerDAO {


    @Autowired
    JdbcTemplate jdbc;

    public List<ReviewTracker> getAllReviewTrackers()
    {
        String query = "SELECT * FROM `4413`.ReviewTracker;";
        return jdbc.query(query, new ReviewTrackerMapper());

    }


    public ReviewTracker getReviewTracker(String book_id)
    {
        String query = "SELECT * FROM `4413`.ReviewTracker where book_id='"+book_id+"';";
        List<ReviewTracker> temp = jdbc.query(query, new ReviewTrackerMapper());
        if(temp.size() == 0) return null;
        else return temp.get(0);
    }

    public boolean containsBook(String bid){
        return getReviewTracker(bid) != null;
    }


    public List<BookReviewTracker> getAllReviewsCombined(){
        String strSelect = "SELECT b.bid, b.title, b.price, b.category, b.quantity, r.rating, r.num_reviews\n" +
                "FROM `4413`.ReviewTracker r \n" +
                "join `4413`.book b on r.book_id = b.bid;";

        return jdbc.query(strSelect,new BookReviewTrackerMapper());
    }
    public void insertReviewTracker(ReviewTracker reviewTracker) throws SQLException {
        String strSelect  = "INSERT INTO ReviewTracker (book_id, rating, num_reviews) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
        preparedStatement.setString(1, reviewTracker.getBid());
        preparedStatement.setDouble(2, reviewTracker.getRating());
        preparedStatement.setInt(3, reviewTracker.getNumReviews());
        preparedStatement.executeUpdate();

    }

    public void removeReviewTracker(String bookID) throws SQLException {
        String query = "DELETE FROM ReviewTracker WHERE (`book_id` = ?);";
        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setString(1,bookID);
        preparedStatement.execute();
    }

    public void updateReviewTracker(String bookID, ReviewTracker newReviewTracker) throws SQLException {
        if(!bookID.equals(newReviewTracker.getBid())) return;


        String query = "UPDATE `4413`.`ReviewTracker` SET `rating` = ?, `num_reviews` = ? WHERE (`book_id` = ?);";


        PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
        preparedStatement.setDouble(1,newReviewTracker.getRating());
        preparedStatement.setInt(2,newReviewTracker.getNumReviews());
        preparedStatement.setString(3,newReviewTracker.getBid());
        preparedStatement.executeUpdate();


    }
}
