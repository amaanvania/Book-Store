package com.example.demo.mapper;

import com.example.demo.beans.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Mapper for address objects
    used to map result sets to
    address objects
*/

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
