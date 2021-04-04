package com.example.demo.ctrl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.dao.AddressDAO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressDAO ad;
	
	@GetMapping("/{id}")
	public Address getAddress(@PathVariable int id)
	{
		return ad.getAddress(id);
	}
	
	@PostMapping("/add")
	public int insertAddress(@RequestBody Address address) throws SQLException
	{
		return ad.insertAddress(address);
	}
	
	@PostMapping("/add2")
	public Object test1(@RequestBody Map<String, Object>[] holder)
	{
		return holder[1];
	}
}
