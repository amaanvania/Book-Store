package com.example.demo.ctrl;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Test controller to verify connection
*/

@RestController
@RequestMapping("/")
public class RequestTestController {

	@GetMapping
	public String checkConnection()
	{
		return "connected";
	}
	
}
