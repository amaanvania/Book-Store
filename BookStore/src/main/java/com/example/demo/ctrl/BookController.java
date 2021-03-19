package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Book> allBooks()
	{
		return bd.getAllBooks();
	}

	@GetMapping("/{bid}")
	public Book getBook(@PathVariable String bid)
	{
		return bd.getBook(bid);
	}
	
	
}
