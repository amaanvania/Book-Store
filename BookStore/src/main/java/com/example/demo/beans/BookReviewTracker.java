package com.example.demo.beans;


/*
    Bean which stores Book + Review object
    Used to populate the catalog
*/


public class BookReviewTracker {



    //primary key
    private String id;
    private String name;
    private String image; // url
    private float price;
    private String category;
    private int quantity;
    double rating;
    int numReviews;

    public BookReviewTracker(){

    }

    public BookReviewTracker(String id, String name, String image, float price, String category, int quantity, double rating, int numReviews) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.rating = rating;
        this.numReviews = numReviews;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }
}
