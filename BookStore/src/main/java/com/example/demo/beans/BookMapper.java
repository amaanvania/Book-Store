package com.example.demo.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book b = new Book();
		b.setId(rs.getString("bid"));
		b.setName(rs.getString("title"));
		b.setPrice((float) rs.getInt("price"));
		b.setCategory(rs.getString("category"));
		return b;
	}

	
	
}
