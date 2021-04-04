package com.example.demo.ctrl;

import com.example.demo.beans.ReviewTracker;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.dao.ReviewTrackerDAO;
import com.example.demo.service.ReviewTrackerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tracker")
public class ReviewTrackerController {

    @Autowired
    ReviewTrackerService rts;

    @Autowired
    ReviewTrackerDAO rtd;


    @GetMapping("/all")
    public List<ReviewTracker> getReviews()
    {
        return rtd.getAllReviewTrackers();
    }
    @GetMapping("/{bid}")
    public ReviewTracker getReview(@PathVariable String bid)
    {
        return rtd.getReviewTracker(bid);
    }

    /* UNTESTED */
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertReviewTrackerItem(@RequestBody ReviewTracker item) throws SQLException {
        rtd.insertReviewTracker(item);
    }

    /* WORKS */
    @DeleteMapping("/{bid}")
    public void removeReviewTracker(@PathVariable String bid) throws SQLException {
        rtd.removeReviewTracker(bid);
    }


}
