package com.example.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReviewService.class})
public class ReviewXSSAttackTest {

	@Autowired
    private ReviewService rs;
	
	String t1;
	String t2;
	@Before
	public void setUp()
	{
		t1 = "<title>Example document: %(title)</title>\r\n";
		t2 = "<script>attack code</script>";
	}
	
    @Test
    public void insertScript()
    {
    	String result = rs.replaceInjection(t1);
    	assert(result.equals("&lttitle>Example document: %(title)&lt/title>\r\n"));
    }
    
    @Test
    public void insertScript2()
    {
    	boolean result = rs.containsScript(t2);
    	assertTrue(result);
    }
}
