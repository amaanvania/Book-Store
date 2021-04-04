package com.example.demo.service;

import com.example.demo.beans.ReviewTracker;
import com.example.demo.dao.ReviewTrackerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReviewTrackerService {

    @Autowired
    ReviewTrackerDAO rtd;

    public boolean updateBooksRating(String bid, double rating) throws SQLException {
        ReviewTracker old = rtd.getReviewTracker(bid);

        if(old == null) return false;

        double oldRating = old.getRating();
        int oldNumReviews = old.getNumReviews();

        int newReviews = oldNumReviews++;

        double newRating = (oldRating + rating) / newReviews;

        return rtd.updateReviewTracker(bid, new ReviewTracker(bid,newRating,newReviews));
    }
}
