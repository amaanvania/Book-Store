package com.example.demo.ctrl;

import com.example.demo.beans.Book;
import com.example.demo.beans.BookReviewTracker;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ReviewTrackerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/*
    Controller to handle book mappings
*/
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookDAO bd;

	@Autowired
	ReviewTrackerDAO rtd;

	//get all books
	@GetMapping("/all")
	public List<BookReviewTracker> allBooks()
	{
		return rtd.getAllReviewsCombined();
	}


	//get book by id
	@GetMapping("/{bid}")
	public BookReviewTracker getBook(@PathVariable String bid) throws SQLException {
		return rtd.getBookReviewsCombined(bid);
	}

	//get book by id for partners
	@GetMapping("/partner/book/{bid}")
	public BookReviewTracker getBookPartner(@PathVariable String bid) throws SQLException {
		return rtd.getBookReviewsCombined(bid);
	}

	//get book by id for partners
	@GetMapping("/partner/all")
	public List<BookReviewTracker> getAllBookPartner() throws SQLException {
		return rtd.getAllReviewsCombined();
	}

	//get book when empty keyword
	@GetMapping("/keyword/")
	public List<Book> getBooksEmptyKeyword(){
		return bd.getAllBooks();
	}


	//get book by keyword
	@GetMapping("/keyword/{keyword}")
	public List<Book> getBooksByKeyword(@PathVariable String keyword){
		return bd.getBooksByKeyword(keyword);
	}
	/* UNTESTED */

	//insert book
	@PostMapping(path="/insert", consumes = "application/json")
	public void insertBook(@RequestBody Book book) throws SQLException {

		bd.insertBook(book);



	}

	/* WORKS */
	//delete book
	@DeleteMapping("/{bid}")
	public void removeBook(@PathVariable String bid) throws SQLException {
		bd.removeBook(bid);
	}
}
