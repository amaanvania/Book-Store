package com.example.demo.dao;

import com.example.demo.beans.Book;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    DAO class for Book objects
    used to get/insert/update/delete
    into/from database
*/

@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	ReviewTrackerDAO rtd;

	@Transactional
	public List<Book> getAllBooks()
	{
		String query = "SELECT * FROM `4413`.book;";
		return jdbc.query(query, new BookMapper());
		
	}

	@Transactional
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

	@Transactional
	public List<String> getAllCategories()
	{
		String query = "SELECT distinct category FROM `4413`.book;";
		return jdbc.queryForList(query, String.class);
	}

	@Transactional
	public Book getBook(String bid)
	{
		String query = "SELECT * FROM `4413`.book where bid = ?;";
		List<Book> books = jdbc.query(query, ps -> ps.setString(1, bid), new BookMapper());
		if(books.size() == 0) return null;
		return books.get(0);
	}

	@Transactional
	public boolean containsBook(String bid){
		return getBook(bid) != null;
	}

	@Transactional
	public List<Book> getBooksByCategory(String cat)
	{
		String query = "SELECT * FROM book where category= ?;";
		return jdbc.query(query, ps -> ps.setString(1, cat), new BookMapper());
	}

	@Transactional
	public void insertBook(Book book) throws SQLException {
		String strSelect  = "INSERT INTO book (bid, title, price, category, quantity, image, publisher, author) VALUES (?, ?, ?, ?,?,?,?,?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(strSelect);
		preparedStatement.setString(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setFloat(3, book.getPrice());
		preparedStatement.setString(4, book.getCategory());
		preparedStatement.setInt(5, book.getQuantity());
		preparedStatement.setString(6, book.getImage());
		preparedStatement.setString(7,book.getPublisher());
		preparedStatement.setString(8,book.getAuthor());
		preparedStatement.executeUpdate();

		if(!rtd.containsBook(book.getId())){
			ReviewTracker newTracker = new ReviewTracker(book.getId());
			rtd.insertReviewTracker(newTracker);
		}


	}

	@Transactional
	public void changeBookQuantity(String bid, int quantity) throws SQLException
	{
		String query = "UPDATE book SET `quantity` = ? WHERE (`bid` = ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
		preparedStatement.setInt(1, quantity);;
		preparedStatement.setString(2,bid);
		preparedStatement.execute();
	}


	@Transactional
	public void updateBook(Book b) throws SQLException
	{
		String query = "UPDATE `4413`.`book` SET `title` = ?, `price` = ?, `category` = ?, `quantity` = ?, `image` = ?, `publisher` = ?, `author` = ? WHERE (`bid` = ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
		preparedStatement.setString(1,b.getName());
		preparedStatement.setFloat(2,b.getPrice());
		preparedStatement.setString(3,b.getCategory());
		preparedStatement.setInt(4,b.getQuantity());
		preparedStatement.setString(5,b.getImage());
		preparedStatement.setString(6,b.getPublisher());
		preparedStatement.setString(7,b.getAuthor());
		preparedStatement.setString(8,b.getId());
		preparedStatement.executeUpdate();
	}


	@Transactional
	public void removeBook(String bookId) throws SQLException {
		String query = "DELETE FROM book WHERE (`bid` = ?);";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
		preparedStatement.setString(1,bookId);
		preparedStatement.execute();
	}

	
	
}
