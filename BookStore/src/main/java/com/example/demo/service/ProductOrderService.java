package com.example.demo.service;

import com.example.demo.beans.Book;
import com.example.demo.beans.CartItem;
import com.example.demo.beans.Payment;
import com.example.demo.beans.ProductOrder;
import com.example.demo.beans.ProductOrderItem;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;


@Service
public class ProductOrderService {

	@Autowired
	UserDAO ud;
	
    @Autowired
    ProductOrderDAO productOrderDAO;
    //INSERT INTO PO (status, user_id, date_time, total_price)
    
    @Autowired
    ProductOrderItemDAO poid;
    //INSERT INTO POItem (bid, quantity,po_id)
    
    @Autowired
    BookDAO bd;
    //    public ProductOrder(int id, String status, int user_id, Timestamp date_time, double total_price) {
        
    
    public String createOrder(Payment item,List<CartItem> cart, HttpServletRequest request)
    {	
    	ProductOrder order = null;
		int oid = 0;
    	try {
			order = new ProductOrder(0, "ORDERED", ud.getUser(item.getUsername()).getId(), new Timestamp(System.currentTimeMillis()), item.getTotalAmount());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Unable to create ProductOrder object";
		}
    	try {
			oid = productOrderDAO.insertProductOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Unable to insert Order";
		}
    	
    	// order inserted, now inserting order items
    	
    	//    public ProductOrderItem(int id, String book_id, int quantity, int po_id) {
    	System.out.println(oid);
    	for (int i = 0 ; i < cart.size(); i++)
    	{
    		CartItem cartItem = cart.get(i);
    		ProductOrderItem poi = new ProductOrderItem(0, cartItem.getBookID(), cartItem.getBookQuantity(), oid);
    		try {
				poid.insertProductOrderItem(poi);
	    		bd.changeBookQuantity(cartItem.getBookID(), bd.getBook(cartItem.getBookID()).getQuantity() - cartItem.getBookQuantity());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Unable to insert one cart item:"+cartItem.getBookID();
			}
    	}
    	
    	
    	
    	return ""+oid;
    }
    
}
