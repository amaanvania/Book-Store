package com.example.demo.ctrl;


import com.example.demo.beans.Book;
import com.example.demo.beans.ProductOrder;
import com.example.demo.beans.ProductOrderItem;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {


    @Autowired
    ProductOrderItemDAO pd;

    @Autowired
    BookDAO bd;


    public void generateReport(){}

    @GetMapping("/top10")
    public List<Book> analytics(){
       return bd.getAllBooks();
    }

    public void anonymizedReport(){

    }
}
