package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.beans.Address;
import com.example.demo.beans.Book;

public class AddressMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Address ad = new Address();
		ad.setId(rs.getInt("id"));
		ad.setStreet(rs.getString("street"));
		ad.setCity(rs.getString("city"));
		ad.setProvince(rs.getString("province"));
		ad.setCountry(rs.getString("country"));
		ad.setZip(rs.getString("zip"));
		ad.setPhone(rs.getString("phone_no"));
		return ad;
	}

}
