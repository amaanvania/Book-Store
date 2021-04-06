package com.example.demo.ctrl;

import com.example.demo.beans.ProductOrderItem;
import com.example.demo.dao.ProductOrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class OrderItemController {

    @Autowired
    ProductOrderItemDAO productOrderItemDAO;


    @GetMapping("/all")
    public List<ProductOrderItem> allProductOrderItems()
    {
        return productOrderItemDAO.getAllProductOrderItems();
    }

    @GetMapping("/{id}")
    public ProductOrderItem getProductOrderItem(@PathVariable int id)
    {
        return productOrderItemDAO.getProductOrderItem(id);
    }

    @GetMapping("/get/{id}")
    public ProductOrderItem getProductOrderItemPartner(@PathVariable int id)
    {
        return productOrderItemDAO.getProductOrderItem(id);
    }


    /* UNTESTED */
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertProductOrderItemItem(@RequestBody ProductOrderItem item) throws SQLException {
        productOrderItemDAO.insertProductOrderItem(item);
    }

    /* WORKS */
    @DeleteMapping("/{id}")
    public void removeProductOrderItem(@PathVariable int id) throws SQLException {
        productOrderItemDAO.removeProductOrderItem(id);
    }
}
