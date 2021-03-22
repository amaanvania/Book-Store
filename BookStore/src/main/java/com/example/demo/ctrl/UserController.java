package com.example.demo.ctrl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.beans.User;
import com.example.demo.service.UserService;


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
	
	@PostMapping(path="/login", consumes = "application/json")
	public String login(@RequestBody User user)
	{
		return us.login(user);
	}
	
}
