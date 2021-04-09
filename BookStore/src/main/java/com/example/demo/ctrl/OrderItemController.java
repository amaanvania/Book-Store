package com.example.demo.ctrl;

import com.example.demo.beans.ProductOrderItem;
import com.example.demo.dao.ProductOrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


/*
    Controller to handle Order Item mappings
    Used to handle Order items
*/
@RestController
@RequestMapping("/item")
public class OrderItemController {

    @Autowired
    ProductOrderItemDAO productOrderItemDAO;

    //get all product order items
    @GetMapping("/all")
    public List<ProductOrderItem> allProductOrderItems()
    {
        return productOrderItemDAO.getAllProductOrderItems();
    }

    //get product order item with id
    @GetMapping("/{id}")
    public ProductOrderItem getProductOrderItem(@PathVariable int id)
    {
        return productOrderItemDAO.getProductOrderItem(id);
    }

    //partner method for getting product items
    @GetMapping("/partner/{bid}")
    public List<ProductOrderItem> getProductOrderItemPartner(@PathVariable String bid)
    {
        return productOrderItemDAO.getProductOrderItem(bid);
    }


    /* UNTESTED */

    //insert product item
    @PostMapping(path="/insert", consumes = "application/json")
    public void insertProductOrderItem(@RequestBody ProductOrderItem item) throws SQLException {
        productOrderItemDAO.insertProductOrderItem(item);
    }

    /* WORKS */

    //delete product item
    @DeleteMapping("/{id}")
    public void removeProductOrderItem(@PathVariable int id) throws SQLException {
        productOrderItemDAO.removeProductOrderItem(id);
    }
}
