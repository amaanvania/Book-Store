package com.example.demo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Book;
import com.example.demo.beans.Category;
import com.example.demo.dao.BookDAO;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	BookDAO bd;
	
	@GetMapping("/all")
	public List<String> getAll() {
		return bd.getAllCategories();

	}	
	
	@GetMapping("/{cat}")
	public List<Book> getBooks(@PathVariable String cat)
	{
		return bd.getBooksByCategory(cat);
	}
}
