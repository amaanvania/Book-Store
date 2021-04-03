package com.example.demo.beans;

public class Book {

	//ID
	private String id;
	private String name;
	private String image; // Image type need to change
	private float price;
	private String category;
	private int quantity;

	public Book()
	{
		this.id = null;
		this.name = null;
		this.image = "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&w=405&h=540&url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F09%2Fhpsorcstone.jpg";
		this.price = 0;
		this.category = null;
		this.quantity = 0;
	}


	public Book(String id, String name, String image, float price, String category, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	public Book(String id, String name, String image, float price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
		this.quantity = 0;
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
