package com.example.demo.service;

import com.example.demo.beans.ReviewTracker;
import com.example.demo.dao.ReviewTrackerDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReviewTrackerService.class})
//@SpringBootTest
public class ReviewTrackerServiceTest {



    @Autowired
    private ReviewTrackerService rts;

    @MockBean
    private ReviewTrackerDAO rtd;


    String bid1, bid2;
    double r1, r2;

    @Before
    public void setUp() throws SQLException {
       bid1 = "b001";
       bid2 = "b002";
       r1 = 324.1;
       r2 = 11.32;
    }
    
    @Test
	public void updateBooksRatingTest() throws SQLException
	{
    	Mockito.when(rtd.getReviewTracker(bid1)).thenReturn(null);
    	Mockito.doNothing().when(rtd).updateReviewTracker(Mockito.any(String.class), Mockito.any(ReviewTracker.class));
    	rts.updateBooksRating(bid1, r1);
		assertTrue(true); // if reaches here with no problem
	}
    
    @Test
	public void updateBooksRatingTestError() throws SQLException
	{
    	Mockito.when(rtd.getReviewTracker(bid1)).thenReturn(null);
    	Mockito.doThrow(new SQLException()).when(rtd).updateReviewTracker(Mockito.any(String.class), Mockito.any(ReviewTracker.class));
    	try {
			rts.updateBooksRating(bid1, r1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(true);
		}
	}
    
    
}
