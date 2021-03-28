package com.example.demo.ctrl;

import com.example.demo.beans.ProductOrder;
import com.example.demo.dao.ProductOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    
    @Autowired
    ProductOrderDAO productOrderDAO;


    @GetMapping("/all")
    public List<ProductOrder> allProductOrders()
    {
        return productOrderDAO.getAllProductOrders();
    }

    @GetMapping("/{id}")
    public ProductOrder getProductOrder(@PathVariable int id)
    {
        return productOrderDAO.getProductOrder(id);
    }


    /* UNTESTED */
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertProductOrder(@RequestBody ProductOrder book) throws SQLException {
        productOrderDAO.insertProductOrder(book);
    }

    /* WORKS */
    @DeleteMapping("/{id}")
    public void removeProductOrder(@PathVariable int id) throws SQLException {
        productOrderDAO.removeProductOrder(id);
    }
}
