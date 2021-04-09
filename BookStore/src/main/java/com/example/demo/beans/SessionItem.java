package com.example.demo.beans;


/*
    Bean which stores SessionItem object
    This object is used to store SessionItems
*/
public class SessionItem {

	private Book book;
	private int quantity;
	
	public SessionItem()
	{
		book = new Book();
		quantity = 99;
		
	}
	
	public SessionItem(Book book, int quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
