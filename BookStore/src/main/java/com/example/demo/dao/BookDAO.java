package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Book;
import com.example.demo.beans.BookMapper;
//https://www.journaldev.com/17053/spring-jdbctemplate-example
@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Book> getAllBooks()
	{
		String query = "SELECT * FROM `4413`.Book;";
		return jdbc.query(query, new BookMapper());
		
	}
}
