package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Book;
import com.example.demo.dao.BookDAO;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookDAO bd;

	@GetMapping("/all")
	public Book[] allBooks()
	{
		//	public Book(String id, String name, String image, float price, String category, boolean inStock, int quantity) {
		Book[] books = {
				new Book("9781234567897", "Harry Potter1", "image", 10, "Fiction", true, 5),
				new Book("9781234567897", "Harry Potter2", "image", 11, "Fiction", true, 6),
				new Book("9781234567897", "Harry Potter3", "image", 12, "Fiction", true, 7),
				new Book("9781234567897", "Harry Potter4", "image", 13, "Fiction", true, 8),
				new Book("9781234567897", "Harry Potter5", "image", 14, "Fiction", true, 9)
		};
		return books;
	}
	
	@GetMapping("/db")
	public List<Book> dbInfo()
	{
		return bd.getAllBooks();
	}
	
	
}
