package com.example.demo.ctrl;

import com.example.demo.beans.ProductOrder;
import com.example.demo.dao.ProductOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


/*
    Controller to handle order mappings
    used for Product Orders
*/
@RestController
@RequestMapping("/order")
public class OrderController {

    
    @Autowired
    ProductOrderDAO productOrderDAO;


    //get all product orders
    @GetMapping("/all")
    public List<ProductOrder> allProductOrders()
    {
        return productOrderDAO.getAllProductOrders();
    }

    //get product order with id
    @GetMapping("/{id}")
    public ProductOrder getProductOrder(@PathVariable int id)
    {
        return productOrderDAO.getProductOrder(id);
    }

    //get product orders under a user
    @GetMapping("/user/{id}")
    public List<ProductOrder> getProductOrderUnderUser(@PathVariable int id)
    {
        return productOrderDAO.getProductsUnderUser(id);
    }

    //get product order with id
    @GetMapping("/partner/{id}")
    public ProductOrder getProductOrderPartner(@PathVariable int id)
    {
        return productOrderDAO.getProductOrder(id);
    }

    //get product orders under a user
    @GetMapping("/partner/user/{id}")
    public List<ProductOrder> getProductOrderUnderUserPartner(@PathVariable int id)
    {
        return productOrderDAO.getProductsUnderUser(id);
    }

    /* UNTESTED */

    //insert a product order
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertProductOrder(@RequestBody ProductOrder book) throws SQLException {
        productOrderDAO.insertProductOrder(book);
    }

    /* WORKS */
    //delete a product order
    @DeleteMapping("/{id}")
    public void removeProductOrder(@PathVariable int id) throws SQLException {
        productOrderDAO.removeProductOrder(id);
    }
}
