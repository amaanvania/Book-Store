package com.example.demo;

public class Book {

	private String id;
	private String name;
	private String image; // Image type need to change
	private float price;
	private String category;
	private boolean inStock;
	private int quantity;

	
	
	public Book(String id, String name, String image, float price, String category, boolean inStock, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
		this.inStock = inStock;
		this.quantity = quantity;
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
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
