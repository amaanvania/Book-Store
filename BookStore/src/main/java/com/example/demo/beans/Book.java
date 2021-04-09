package com.example.demo.beans;


	/*
  	Bean which stores Book object
  	Used to store book objects
  	from the database
   */


public class Book {



	//primary key
	private String id;
	private String name;
	private String image; //image url
	private float price;
	private String category;
	private int quantity;

	private String author;

	private String publisher;


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public Book()
	{
		this.id = null;
		this.name = null;
		this.image = null;
		this.price = 0;
		this.category = null;
		this.quantity = 0;
	}


	public Book(String id, String name, String image, float price, String category, int quantity, String author, String publisher) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.author = author;
		this.publisher = publisher;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
