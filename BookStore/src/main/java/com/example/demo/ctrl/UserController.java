package com.example.demo.ctrl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping("/{username}")
	public UserAddress getUser(@PathVariable String username)
	{
		return us.getUserInfo(username);
	}
	
	@PostMapping(path="/register", consumes = "application/json")
	public String register(@RequestBody UserAddress ud)
	{
		System.out.println("Received register request");
		return us.registerUser(ud);
	}
	
	@PostMapping(path="/login", consumes = "application/json")
	public String login(@RequestBody User user)
	{
		return us.login(user);
	}
	
}
