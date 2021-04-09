package com.example.demo.beans;

/*
    Bean which stores annomized report object
    Used for user analytics bys admins
*/

public class AnnomizedReport {



    String username;

    double total_amount;

    String zip;

    public AnnomizedReport(){
        this.username = "****";
    }
    public AnnomizedReport(String username, double total_amount, String zip) {
        this.username = username;
        this.total_amount = total_amount;
        this.zip = zip;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getZip_code() {
        return zip;
    }

    public void setZip_code(String zip_code) {
        this.zip = zip_code;
    }
}
