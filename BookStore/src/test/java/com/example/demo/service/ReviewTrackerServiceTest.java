package com.example.demo.service;

import com.example.demo.beans.Address;
import com.example.demo.beans.Book;
import com.example.demo.beans.ReviewTracker;
import com.example.demo.beans.User;
import com.example.demo.dao.AddressDAO;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ReviewTrackerDAO;
import com.example.demo.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReviewTrackerService.class})
//@SpringBootTest
public class ReviewTrackerServiceTest {



    @Autowired
    private ReviewTrackerService rts;

    @MockBean
    private ReviewTrackerDAO ud;

    @MockBean
    BookDAO bd;


    ReviewTracker r1;
    Book b1;


    @Before
    public void setUp() throws SQLException {
        b1 = new Book("b100","test","",2,"",1);
        bd.insertBook(b1);

        r1 = new ReviewTracker();
    }
    
    @Test
	public void t1()
	{
		assertTrue(true);
	}
}
