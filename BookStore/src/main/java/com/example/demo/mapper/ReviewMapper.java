package com.example.demo.mapper;

import com.example.demo.beans.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for Review objects
    used to map result sets to
    Review objects
*/


public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Review r = new Review();
        r.setReview_id(rs.getInt("review_id"));
        r.setBook_id(rs.getString("book_id"));
        r.setReview(rs.getString("review"));
        r.setRating(rs.getFloat("rating"));
        r.setUser_id(rs.getInt("user_id"));
        String name = rs.getString("fname") + " " + rs.getString("lname");
        r.setName(name);
        r.setDate_time(rs.getTimestamp("date_time"));
        return r;
    }
}
