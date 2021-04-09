package com.example.demo.beans;

import java.sql.Timestamp;

/*
    Bean which stores Review objects
    This object is used to store Book reviews
*/
public class Review {
    //primary key
    int review_id;

    //foreign key to refer to book
    String book_id;

    String review;

    double rating;


    //foreign key to refer to user
    int user_id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Timestamp date_time;

    public Review(){

    }

    public Review(int review_id, String book_id, String review, double rating, int user_id, Timestamp date_time) {
        this.review_id = review_id;
        this.book_id = book_id;
        this.review = review;
        this.rating = rating;
        this.user_id = user_id;
        this.date_time = date_time;
    }


    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }
}
