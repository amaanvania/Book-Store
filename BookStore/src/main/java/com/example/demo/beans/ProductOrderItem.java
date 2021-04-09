package com.example.demo.beans;

/*
    Bean which stores Order Item object
    This object is used to store items in a given order
*/
public class ProductOrderItem {
    //primary key
    int id;


    //foreign key
    String book_id;

    int quantity;

    //foreign key to refer to order
    int po_id;


    public ProductOrderItem(){

    }

    public ProductOrderItem(int id, String book_id, int quantity, int po_id) {
        this.id = id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.po_id = po_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPo_id() {
        return po_id;
    }

    public void setPo_id(int po_id) {
        this.po_id = po_id;
    }


}
