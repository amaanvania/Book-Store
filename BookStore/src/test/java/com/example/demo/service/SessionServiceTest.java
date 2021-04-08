package com.example.demo.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.BookDAO;

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
	
	@Test
	public void t1()
	{
		assertTrue(true);
	}
}
