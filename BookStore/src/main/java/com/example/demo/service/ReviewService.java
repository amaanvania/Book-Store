package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public String replaceInjection(String input){
        return input.replaceAll("<", "&lt");
    }

    public boolean containsScript(String input){
        return input.contains("<script>");
    }
}
