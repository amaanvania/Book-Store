package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/all")
	public Book allBooks()
	{
		//	public Book(String id, String name, String image, float price, String category, boolean inStock, int quantity) {

		return new Book("9781234567897", "Harry Potter", "image", 10, "Fiction", true, 5);
	}
	
	@GetMapping("/db")
	public List<String> dbInfo()
	{
		return jdbc.queryForList("SELECT Name FROM city where ID=1;", String.class);
	}
	
	
}
