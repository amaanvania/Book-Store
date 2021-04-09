package com.example.demo.service;

import com.example.demo.beans.Address;
import com.example.demo.beans.User;
import com.example.demo.beans.UserAddress;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserService.class, PasswordEncoder.class})
//@SpringBootTest
public class UserServiceTest {

	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserDAO ud;
	
	@MockBean AddressDAO ad;

	@MockBean PasswordEncoder pe;
	
	User u1;
	User u2;
	User u3;
	Address ad1;
	@Before
	public void setUp()
	{
		u1 = new User(1, 1, "John", "Doe", "johndoe", "password123");
		u2 = new User(1, 1, "John", "Doe", "johndoe", "password1234");
		u3 = new User(1, 1, "John", "Doe", "johndoe2", "password1234");
		//int id, String street,String city, String province, String country, String zip, String phone
		ad1 = new Address(0,"street","city","ON","Canada","f3f0c","90944235934");
	}
	// invalid register
	@Test
	public void testRegisterUser1() throws Exception {
		//User(int id, int address, String fname, String lname, String username, String password) {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u1);
		assertTrue(service.registerUser(new UserAddress(u1,ad1)).equals("Unable to Create Account"));
		
	}
	// valid register
	@Test
	public void testRegisterUser2() throws Exception {
		//User(int id, int address, String fname, String lname, String username, String password) {
		Mockito.when(ud.getUser(u1.getUsername())).thenThrow(new Exception());
		Mockito.when(ud.insert(u1)).thenReturn(1);
		assertTrue(service.registerUser(new UserAddress(u1,ad1)).equals("Created"));
		
	}
	// valid login
	@Test
	public void testLogin1() throws Exception {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u1);
		Mockito.when(pe.matches(u1.getPassword(),u1.getPassword())).thenReturn(true);
		assertTrue(service.login(u1).equals("logged in"));
	}
	
	// invalid password
	@Test
	public void testLogin2() throws Exception {
		Mockito.when(ud.getUser(u1.getUsername())).thenReturn(u2);
		assertTrue(service.login(u1).equals("invalid password"));
	}
}
