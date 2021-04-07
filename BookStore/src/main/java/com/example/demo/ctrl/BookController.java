package com.example.demo.ctrl;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.beans.BookReviewTracker;
import com.example.demo.beans.Review;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.dao.ReviewTrackerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Book;
import com.example.demo.dao.BookDAO;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookDAO bd;

	@Autowired
	ReviewTrackerDAO rtd;

	@GetMapping("/all")
	public List<BookReviewTracker> allBooks()
	{
		return rtd.getAllReviewsCombined();
	}

	@GetMapping("/{bid}")
	public BookReviewTracker getBook(@PathVariable String bid) throws SQLException {
		return rtd.getBookReviewsCombined(bid);
	}

	@GetMapping("/keyword/")
	public List<Book> getBooksEmptyKeyword(){
		return bd.getAllBooks();
	}

	@GetMapping("/keyword/{keyword}")
	public List<Book> getBooksByKeyword(@PathVariable String keyword){
		return bd.getBooksByKeyword(keyword);
	}
	/* UNTESTED */
	@PostMapping(path="/insert", consumes = "application/json")
	public void insertBook(@RequestBody Book book) throws SQLException {

		bd.insertBook(book);



	}

	/* WORKS */
	@DeleteMapping("/{bid}")
	public void removeBook(@PathVariable String bid) throws SQLException {
		bd.removeBook(bid);
	}
}
