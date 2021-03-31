package com.example.demo.beans;

import java.io.Serializable;

public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookName;
	private int quantity;
	
	public CartItem(String bookName, int quantity)  {
		super();
		this.bookName = bookName;
		this.quantity = quantity;
	}
	
	public String getbookName() {
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
