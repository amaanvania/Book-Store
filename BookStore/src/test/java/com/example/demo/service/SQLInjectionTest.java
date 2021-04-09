package com.example.demo.service;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserDAO.class})
public class SQLInjectionTest {

	@Autowired
	private UserDAO db;
	
	@MockBean JdbcTemplate jdbc;
	
	User u1;
	User u2;

	@Before
	public void setUp()
	{
		u1 = new User(1, 1, "John", "Doe", "\" or \"\"=\"", "\" or \"\"=\"");
		u2 = new User(1, 1, "John", "Doe", "105 OR 1=1", "105 OR 1=1");

	}
	
	@Test
	public void testLoginSQLInjection() throws Exception {
		assertFalse(db.userExists(u1.getUsername()));
		assertNull(db.getUser(u1.getUsername()));
	}
	
	@Test
	public void testLoginSQLInjection2() throws Exception
	{
		assertFalse(db.userExists(u2.getUsername()));
		assertNull(db.getUser(u2.getUsername()));
	}
}
