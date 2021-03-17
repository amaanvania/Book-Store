package com.example.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@GetMapping("/all")
	public Category[] getAll() {
		//	public Category(String id, String name, String image_url) {
		Category[] cat = {
				new Category("123", "Horror", "https://assets.entrepreneur.com/content/3x2/2000/20191219170611-GettyImages-1152794789.jpeg"),
				new Category("123", "Sci-Fi", "https://assets.entrepreneur.com/content/3x2/2000/20191219170611-GettyImages-1152794789.jpeg"),
				new Category("123", "Fiction", "https://assets.entrepreneur.com/content/3x2/2000/20191219170611-GettyImages-1152794789.jpeg")
		};
		return cat;

	}	
	
	@GetMapping("/{cat}")
	public Category getCategory(@PathVariable String cat)
	{
		return new Category("123",cat,"https://assets.entrepreneur.com/content/3x2/2000/20191219170611-GettyImages-1152794789.jpeg");
	}
}
