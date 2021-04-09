package com.example.demo.beans;

import java.sql.Timestamp;

/*
    Bean which stores ProductOrder object
    This object is used to store product orders
*/
public class ProductOrder {
    //primary key
    int id;

    String status;

    int user_id;

    Timestamp date_time;

    double total_price;

    public ProductOrder(){

    }
    public ProductOrder(int id, String status, int user_id, Timestamp date_time, double total_price) {
        this.id = id;
        this.status = status;
        this.user_id = user_id;
        this.date_time = date_time;
        this.total_price = total_price;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
