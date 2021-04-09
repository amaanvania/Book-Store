package com.example.demo.ctrl;

import com.example.demo.beans.Address;
import com.example.demo.dao.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

/*
    Controller to handle address mappings
*/
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressDAO ad;

	//method which returns address from given id
	@GetMapping("/{id}")
	public Address getAddress(@PathVariable int id)
	{
		return ad.getAddress(id);
	}


	//method which inserts address
	@PostMapping("/add")
	public int insertAddress(@RequestBody Address address) throws SQLException
	{
		return ad.insertAddress(address);
	}


	//method which updates address
	@PostMapping("/update")
	public void updateAddress(@RequestBody Address address) throws SQLException {
		ad.updateAddress(address);
	}

	//testing method
	@PostMapping("/add2")
	public Object test1(@RequestBody Map<String, Object>[] holder)
	{
		return holder[1];
	}
}
