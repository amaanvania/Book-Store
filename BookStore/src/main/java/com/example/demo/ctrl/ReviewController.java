package com.example.demo.ctrl;

import com.example.demo.beans.Review;
import com.example.demo.dao.ReviewDAO;
import com.example.demo.service.ReviewTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewDAO rd;

    @Autowired
    ReviewTrackerService rts;

    @GetMapping("/all")
    public List<Review> getReviews()
    {
        return rd.getAllReviews();
    }
    @GetMapping("/{id}")
    public Review getReview(@PathVariable int id)
    {
        return rd.getReview(id);
    }

    /* UNTESTED */
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertReview(@RequestBody Review item) throws SQLException {
        boolean b = rd.insertReview(item);
        rts.updateBooksRating(item.getBook_id(), item.getRating());

    }

    /* WORKS */
    @DeleteMapping("/{id}")
    public void removeReview(@PathVariable int id) throws SQLException {
        Review curr = rd.getReview(id);
        if(curr == null) return;

        rd.removeReview(id);
        rts.decrementBooksRating(curr.getBook_id(),curr.getRating());


    }
}
