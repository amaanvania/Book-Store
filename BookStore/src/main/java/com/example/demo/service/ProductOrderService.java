package com.example.demo.service;

import com.example.demo.dao.ProductOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductOrderService {

    @Autowired
    ProductOrderDAO productOrderDAO;

}
