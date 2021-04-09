package com.example.demo.service;

import com.example.demo.beans.Book;
import com.example.demo.beans.CartItem;
import com.example.demo.dao.BookDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SessionService.class})
//@SpringBootTest
public class SessionServiceTest {
	
	@Autowired
	SessionService s;
	
	@MockBean
	BookDAO bd;
	@MockBean PaymentService payment;
	@MockBean ProductOrderService pod;
	
	List<CartItem> c1;
	@Before
	public void setUp()
    {
		c1 = new ArrayList<CartItem>();
		// CartItem(String bookID, int bookQuantity)
		c1.add(new CartItem("b001",5));
		c1.add(new CartItem("b002",43));
		c1.add(new CartItem("b002",1));

    }
	@Test
	public void validateValidCart()
	{
		//Book(String id, String name, String image, float price, String category, int quantity, String author, String publisher) 
		Mockito.when(bd.getBook(Mockito.any(String.class))).thenReturn(new Book("1","book","",42,"",99,"",""));
		assertTrue(s.validateCartQuantities(c1).equals("valid"));
	}
	@Test
	public void validateInvalidCart()
	{
		//Book(String id, String name, String image, float price, String category, int quantity, String author, String publisher) 
		Mockito.when(bd.getBook(Mockito.any(String.class))).thenReturn(new Book("1","book","",42,"",1,"",""));
		assertTrue(s.validateCartQuantities(c1).length() > 10);
	}
	
}
