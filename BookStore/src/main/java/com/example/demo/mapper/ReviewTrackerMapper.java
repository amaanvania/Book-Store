package com.example.demo.mapper;

import com.example.demo.beans.ReviewTracker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for ReviewTracker objects
    used to map result sets to
    ReviewTracker objects
*/
public class ReviewTrackerMapper implements RowMapper<ReviewTracker> {

    @Override
    public ReviewTracker mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        ReviewTracker r = new ReviewTracker();
        r.setBid(rs.getString("book_id"));
        r.setRating(rs.getFloat("rating"));
        r.setNumReviews(rs.getInt("num_reviews"));
        return r;
    }
}
