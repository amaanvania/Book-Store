package com.example.demo.mapper;

import com.example.demo.beans.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Review r = new Review();
        r.setReview_id(rs.getInt("review_id"));
        r.setBook_id(rs.getString("book_id"));
        r.setRating(rs.getFloat("rating"));
        r.setUser_id(rs.getInt("user_id"));
        r.setDate_time(rs.getTimestamp("date_time"));
        return r;
    }
}
