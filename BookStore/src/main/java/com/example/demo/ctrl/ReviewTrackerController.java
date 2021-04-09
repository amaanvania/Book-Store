package com.example.demo.ctrl;

import com.example.demo.beans.BookReviewTracker;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.dao.ReviewTrackerDAO;
import com.example.demo.service.ReviewTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


/*
    Controller to handle Review Tracker mappings
    Used to keep running sum average and
    total number of reviews for books
*/
@RestController
@RequestMapping("/tracker")
public class ReviewTrackerController {

    @Autowired
    ReviewTrackerService rts;

    @Autowired
    ReviewTrackerDAO rtd;


    //get all review trackers
    @GetMapping("/all")
    public List<ReviewTracker> getReviews()
    {
        return rtd.getAllReviewTrackers();
    }


    //get all book+review objects combined
    @GetMapping("/combined/all")
    public List<BookReviewTracker> getReviewsCombined()
    {
        return rtd.getAllReviewsCombined();
    }


    //get specific book+Review object
    @GetMapping("/combined/{bid}")
    public BookReviewTracker getBookReviewCombined(@PathVariable String bid) throws SQLException {
        return rtd.getBookReviewsCombined(bid);
    }

    //get review by book
    @GetMapping("/{bid}")
    public ReviewTracker getReview(@PathVariable String bid)
    {
        return rtd.getReviewTracker(bid);
    }

    /* UNTESTED */

    //insert new book tracking object
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertReviewTrackerItem(@RequestBody ReviewTracker item) throws SQLException {
        rtd.insertReviewTracker(item);
    }

    /* WORKS */

    //delete a book tracking object
    @DeleteMapping("/{bid}")
    public void removeReviewTracker(@PathVariable String bid) throws SQLException {
        rtd.removeReviewTracker(bid);
    }


}
