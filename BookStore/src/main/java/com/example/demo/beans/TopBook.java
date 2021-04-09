package com.example.demo.beans;

/*
    Bean which stores TopBook object
    this is used to store the top 10 book sellers

*/
public class TopBook {

    public String bid;

    public String title;

    public int quantity;

    public double price;

    public double revenue;

    public TopBook(){

    }

    public TopBook(String bid, String title, int quantity, double price, double revenue) {
        this.bid = bid;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.revenue = revenue;
    }


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
