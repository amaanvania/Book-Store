package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Address;
import com.example.demo.mapper.AddressMapper;

@Repository
public class AddressDAO {
	@Autowired
	JdbcTemplate jdbc;
	
	// get address given address id. stored with user
	public Address getAddress(int addressId)
	{
		String query = "SELECT * FROM `4413`.Address where id= ?;";
		List<Address> list = jdbc.query(query, ps -> ps.setInt(1, addressId), new AddressMapper());
		if(list.size() ==0) return null;
		return list.get(0);
	}


	// return the address id
	public int insertAddress(Address address) throws SQLException
	{
		String query = "INSERT INTO `4413`.Address(street,city,province,country,zip,phone_no) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = jdbc.getDataSource().getConnection().prepareStatement(query);
		preparedStatement.setString(1, address.getStreet());
		preparedStatement.setString(2, address.getCity());
		preparedStatement.setString(3, address.getProvince());
		preparedStatement.setString(4, address.getCountry());
		preparedStatement.setString(5, address.getZip());
		preparedStatement.setString(6, address.getPhone());

		int response =  preparedStatement.executeUpdate();
		if (response != 0)
		{
			return jdbc.queryForObject("SELECT COUNT(*) FROM `4413`.Address", Integer.class);
		}
		return response;
	}
}
