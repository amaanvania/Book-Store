package com.example.demo.service;

import com.example.demo.beans.ReviewTracker;
import com.example.demo.dao.ReviewTrackerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/*
    Service Class used to provide
    services and functionality
    for ReviewTrackers
*/



@Service
public class ReviewTrackerService {

    @Autowired
    ReviewTrackerDAO rtd;


    //update a books rating after new review
    public void updateBooksRating(String bid, double rating) throws SQLException {
        ReviewTracker old = rtd.getReviewTracker(bid);

        if(rating < 1 || rating > 5) return;
        if(old == null) return;

        double oldRating = old.getRating();
        int oldNumReviews = old.getNumReviews();

        int newReviews = oldNumReviews + 1;
        double newRating = ((oldRating * old.getNumReviews()) + rating) / newReviews;
        System.out.println(newRating);
        rtd.updateReviewTracker(bid, new ReviewTracker(bid,newRating,newReviews));
    }


    //decrement a books rating after deleted review
    public void decrementBooksRating(String bid, double rating) throws SQLException {
        ReviewTracker old = rtd.getReviewTracker(bid);

        if(rating < 1 || rating > 5) return;
        if(old == null) return;

        double oldRating = old.getRating();
        int oldNumReviews = old.getNumReviews();

        int newReviews = oldNumReviews--;

        double newRating = ((oldRating * oldNumReviews) - rating) / newReviews;

        rtd.updateReviewTracker(bid, new ReviewTracker(bid,newRating,newReviews));
    }


    //alter a books review if user edits
    public void updateBooksRatingEdit(String bid, double rating) throws SQLException {
        ReviewTracker old = rtd.getReviewTracker(bid);

        if(rating < 1 || rating > 5) return;
        if(old == null) return;

        double oldRating = old.getRating();



        double newRating = ((oldRating * old.getNumReviews()) + (rating - old.getRating())) / (old.getNumReviews());

        rtd.updateReviewTracker(bid, new ReviewTracker(bid,newRating,old.getNumReviews()));
    }
}
