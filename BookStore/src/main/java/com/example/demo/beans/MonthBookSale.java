package com.example.demo.beans;


/*
    Bean which stores MonthBookSale object
    This object is used for analytics
    to store monthly book sales
*/
public class MonthBookSale {
    //primary key
    String bid;

    String title;

    double price;

    int amount_sold;

    double monthly_sales;


    public MonthBookSale(){

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount_sold() {
        return amount_sold;
    }

    public void setAmount_sold(int amount_sold) {
        this.amount_sold = amount_sold;
    }

    public double getMonthly_sales() {
        return monthly_sales;
    }

    public void setMonthly_sales(double monthly_sales) {
        this.monthly_sales = monthly_sales;
    }

    public MonthBookSale(String bid, String title, double price, int amount_sold, double monthly_sales) {
        this.bid = bid;
        this.title = title;
        this.price = price;
        this.amount_sold = amount_sold;
        this.monthly_sales = monthly_sales;
    }
}
