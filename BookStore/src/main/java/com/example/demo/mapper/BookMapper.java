package com.example.demo.mapper;

import com.example.demo.beans.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Mapper for book objects
    used to map result sets to
    book objects
*/

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book b = new Book();
		b.setId(rs.getString("bid"));
		b.setName(rs.getString("title"));
		b.setPrice(rs.getFloat("price"));
		b.setQuantity(rs.getInt("quantity"));
		b.setCategory(rs.getString("category"));
		b.setImage(rs.getString("image"));
		return b;
	}

	
	
}
