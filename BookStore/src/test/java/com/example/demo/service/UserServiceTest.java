package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserService.class})

public class UserServiceTest {

	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserDAO ud;
	
	User u1;
	User u2;
	User u3;
	@Before
	public void setUp()
	{
		u1 = new User(1, 1, "John", "Doe", "johndoe", "password123");
		u2 = new User(1, 1, "John", "Doe", "johndoe", "password1234");
		u3 = new User(1, 1, "John", "Doe", "johndoe2", "password1234");

	}
	// invalid register
	@Test
	public void testRegisterUser1() throws Exception {
		//User(int id, int address, String fname, String lname, String username, String password) {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u1);
		assertTrue(service.registerUser(u1).equals("Unable to Create Account"));
		
	}
	// valid register
	@Test
	public void testRegisterUser2() throws Exception {
		//User(int id, int address, String fname, String lname, String username, String password) {
		Mockito.when(ud.getUser(u1.getUsername())).thenThrow(new Exception());
		Mockito.when(ud.insert(u1)).thenReturn(1);
		assertTrue(service.registerUser(u1).equals("Created"));
		
	}
	// valid login
	@Test
	public void testLogin1() throws Exception {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u1);
		assertTrue(service.login(u1).equals("logged in"));
	}
	
	// invalid password
	@Test
	public void testLogin2() throws Exception {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u2);
		assertTrue(service.login(u1).equals("invalid password"));
	}
}
