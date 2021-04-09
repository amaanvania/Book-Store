package com.example.demo.service;

import org.springframework.stereotype.Service;

/*
    Service Class used to provide
    services and functionality
    for Reviews
*/


@Service
public class ReviewService {

    //replace potential injections
    public String replaceInjection(String input){
        return input.replaceAll("<", "&lt");
    }


    //check if method contains dangerous script
    public boolean containsScript(String input){
        return input.contains("<script>");
    }
}
