package com.example.demo.service;

import com.example.demo.beans.*;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProductOrderService.class})
//@SpringBootTest
public class ProductOrderServiceTest {

	@Autowired
	private ProductOrderService service;

	
	@MockBean
	UserDAO ud;
	@MockBean
    ProductOrderDAO productOrderDAO;
	@MockBean
    ProductOrderItemDAO poid;    
	@MockBean
    BookDAO bd;
	
	Payment p1;
	List<CartItem> c1;
	HttpServletRequest req;
	User u1; 
	@Before
    public void setUp()
    {
		//Payment(String ccd, String username, double totalAmount)
		p1 = new Payment("34joijf3443","johndoe", 42.44);
		c1 = new ArrayList<CartItem>();
		// CartItem(String bookID, int bookQuantity)
		c1.add(new CartItem("b001",5));
		c1.add(new CartItem("b002",43));
		c1.add(new CartItem("b002",1));
		u1 = new User(1, 1, "John", "Doe", "johndoe", "password123");

    }
	
	@Test
	public void createOrderNoUser() throws Exception
	{
		Mockito.when(ud.getUser(p1.getUsername())).thenThrow(new Exception());
		String response = service.createOrder(p1, c1, req);
		assertTrue(response.equals("Unable to create ProductOrder object"));
	}
	
	@Test
	public void insertOrderError() throws Exception
	{
		Mockito.when(ud.getUser(p1.getUsername())).thenReturn(u1);
		Mockito.when(productOrderDAO.insertProductOrder(Mockito.any(ProductOrder.class))).thenThrow(new SQLException());
		String response = service.createOrder(p1, c1, req);
		assertTrue(response.equals("Unable to insert Order"));
	}
	
	@Test
	public void insertProductOrderItemError() throws Exception
	{
		Mockito.when(ud.getUser(p1.getUsername())).thenReturn(u1);
		Mockito.when(productOrderDAO.insertProductOrder(Mockito.any(ProductOrder.class))).thenReturn(111);
		Mockito.doThrow(new SQLException()).when(poid).insertProductOrderItem(Mockito.any(ProductOrderItem.class));
		String response = service.createOrder(p1, c1, req);
		assertTrue(response.contains("Unable to insert one cart item:"));
	}
	
}
