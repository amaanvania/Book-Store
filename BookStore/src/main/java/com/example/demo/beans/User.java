package com.example.demo.beans;
/*
    Bean which stores User objects
    This object is used to store registered users
*/

public class User{


    //primary key to uniquely identify users
    int id;
    int address;
    String fname;
    String lname;
    String username;
    String password;

    boolean enabled;

    String role;

    public User(){

    }

    public User(int id, int address, String fname, String lname, String username, String password) {
        this.id = id;
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        enabled = true;
        this.role = "USER";
    }

    public User(int id, int address, String fname, String lname, String username, String password, String role) {
        this.id = id;
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
