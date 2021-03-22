package com.example.demo.ctrl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Book;
import com.example.demo.beans.User;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	
	@PostMapping(path="/register", consumes = "application/json")
	public String register(@RequestBody User user)
	{
		return us.registerUser(user);
	}
	
	
}
