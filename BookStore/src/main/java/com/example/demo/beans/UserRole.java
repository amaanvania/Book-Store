package com.example.demo.beans;


/*
    Bean which stores UserRole object
    Used to store Roles for users
*/
public class UserRole {

    //primary key / foreign key which refers to users
    int id;


    //primary key / foreign key which refers to role
    int role_id;


    public UserRole(int id, int role_id) {
        this.id = id;
        this.role_id = role_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
