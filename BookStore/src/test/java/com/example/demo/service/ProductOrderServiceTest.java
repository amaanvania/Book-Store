package com.example.demo.service;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

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
	
	@Test
	public void t1()
	{
		assertTrue(true);
	}
	
}
