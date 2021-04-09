package com.example.demo.mapper;

import com.example.demo.beans.BookReviewTracker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Mapper for BookReviewTracker objects
    used to map result sets to
    BookReviewTracker objects
*/


public class BookReviewTrackerMapper implements RowMapper<BookReviewTracker> {
    @Override
    public BookReviewTracker mapRow(ResultSet rs, int rowNum) throws SQLException {

        BookReviewTracker result = new BookReviewTracker();
        result.setId(rs.getString("bid"));
        result.setName(rs.getString("title"));
        result.setPrice(rs.getFloat("price"));
        result.setQuantity(rs.getInt("quantity"));
        result.setImage(rs.getString("image"));
        result.setCategory(rs.getString("category"));
        result.setRating(rs.getFloat("rating"));
        result.setNumReviews(rs.getInt("num_reviews"));

        return result;
    }
}
