package com.example.demo.beans;


/*
    Bean which stores Payment object
    This object is used at checkout
*/
public class Payment {
	
	private String username;
	private String ccd;
	private double totalAmount;

	public Payment()
	{
		ccd = " ";
		username = " ";
	}
	public Payment(String ccd, String username, double totalAmount) {
		super();
		this.ccd = ccd;
		this.username = username;
		this.totalAmount = totalAmount;
	}

	public String getCcd() {
		return ccd;
	}

	public void setCcd(String ccd) {
		this.ccd = ccd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
