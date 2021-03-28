package com.example.demo.beans;

public class ProductOrder {

    int id;

    String status;

    int user_id;

    public ProductOrder(){

    }
    public ProductOrder(int id, String status, int user_id) {
        this.id = id;
        this.status = status;
        this.user_id = user_id;
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
