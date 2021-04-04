package com.example.demo.beans;

public class ReviewTracker {

    String bid;
    double rating;
    int numReviews;


    public ReviewTracker(){

    }
    public ReviewTracker(String bid){
        this.bid = bid;
        rating = 0;
        numReviews = 0;
    }

    public ReviewTracker(String bid, double rating, int numReviews){
        this.bid = bid;
        this.rating = rating;
        this.numReviews = numReviews;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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
