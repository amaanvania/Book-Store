package com.example.demo.ctrl;


import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    Controller to handle user mappings
    used to register and login users
*/
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;


	//get user by name
	@GetMapping("/{username}")
	public UserAddress getUser(@PathVariable String username)
	{
		return us.getUserInfo(username);
	}


	//register user
	@PostMapping(path="/register", consumes = "application/json")
	public String register(@RequestBody UserAddress ud)
	{
		System.out.println("Received register request");
		return us.registerUser(ud);
	}


	//login user
	@PostMapping(path="/login", consumes = "application/json")
	public String login(@RequestBody User user)
	{
		return us.login(user);
	}
	
}
