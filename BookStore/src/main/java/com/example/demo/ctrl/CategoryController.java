package com.example.demo.ctrl;

import com.example.demo.beans.Book;
import com.example.demo.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
    Controller to handle category mappings
    used to dynamically populate categories
    in the catalogue
*/
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	BookDAO bd;


	//get all categories, used to populate catalogs categories
	@GetMapping("/all")
	public List<String> getAll() {
		return bd.getAllCategories();

	}	

	//get books under categories, used for filtering
	@GetMapping("/{cat}")
	public List<Book> getBooks(@PathVariable String cat)
	{
		return bd.getBooksByCategory(cat);
	}


}
