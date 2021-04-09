package com.example.demo.beans;
/*
    Bean which stores address object
    Used to represent address objects
    from the database
*/
public class Address {


    //primary key
    int id;
    String street;
    String city;
    String province;
    String country;
    String zip;
    String phone;

    
    public Address() {
    	 this.id = 0;
         this.street = null;
         this.city = null;
         this.province = null;
         this.country = null;
         this.zip = null;
         this.phone = null;
	}

	public Address(int id, String street,String city, String province, String country, String zip, String phone) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.zip = zip;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city)
    {
    	this.city = city;
    }
    
    public String getCity()
    {
    	return this.city;
    }
    
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
