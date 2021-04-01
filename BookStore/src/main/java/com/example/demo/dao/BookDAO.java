package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Book;
import com.example.demo.mapper.BookMapper;
//https://www.journaldev.com/17053/spring-jdbctemplate-example
@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Book> getAllBooks()
	{
		String query = "SELECT * FROM `4413`.book;";
		return jdbc.query(query, new BookMapper());
		
	}

	public List<Book> getBooksByKeyword(String keyword)
	{
		String query = "SELECT * FROM `4413`.book;";
		List<Book> books = jdbc.query(query, new BookMapper());
		if(keyword == null) return books;
		List<Book> result = new ArrayList<>();
		String lowercaseFormatted = keyword.toLowerCase().replace("+"," ");
		for(Book b : books){
			if(b.getName().toLowerCase().contains(lowercaseFormatted))
				result.add(b);
		}

		return result;

	}
	
	public List<String> getAllCategories()
	{
		String query = "SELECT distinct category FROM `4413`.book;";
		return jdbc.queryForList(query, String.class);
	}
	
	public Book getBook(String bid)
	{
		String query = "SELECT * FROM `4413`.book where bid='"+bid+"';";
		return jdbc.queryForObject(query, new BookMapper());
	}
	
	public List<Book> getBooksByCategory(String cat)
	{
		String query = "SELECT * FROM `4413`.Book where category='"+cat+"';"; 
		return jdbc.query(query, new BookMapper());
	}

	public void insertBook(Book book) throws SQLException {
		String strSelect  = "INSERT INTO book (bid, title, price, category) VALUES (?, ?, ?, ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
		preparedStatement.setString(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setFloat(3, book.getPrice());
		preparedStatement.setString(4, book.getCategory());
		preparedStatement.executeUpdate();

	}

	public void removeBook(String bookId) throws SQLException {
		String query = "DELETE FROM book WHERE (`bid` = ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
		preparedStatement.setString(1,bookId);
		preparedStatement.execute();
	}

	
	
}
