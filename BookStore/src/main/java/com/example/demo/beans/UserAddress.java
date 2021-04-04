package com.example.demo.beans;

public class UserAddress {

	private User user;
	private Address address;
	
	
	public UserAddress(User user, Address address) {
		super();
		this.user = user;
		this.address = address;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
