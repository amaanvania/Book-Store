package com.example.demo.service;

import com.example.demo.beans.Payment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/*
    Service Class used to provide
    services and functionality
    for Payments
*/

@Service
public class PaymentService {

	// 1 for valid, 0 for invalid payment

	//used for 3 consecutive requests
	public int validatePayment(Payment payment, HttpServletRequest request)
	{
		Object requestCount = request.getSession().getAttribute("requestCount");
		if (requestCount == null)
		{
            request.getSession().setAttribute("requestCount", 1);
            return 1;
		}
		int convReqCount = (int) requestCount;
		convReqCount++;
        request.getSession().setAttribute("requestCount", convReqCount);
		
        if (convReqCount % 3 == 0)
        {
        	return 0;
        }
        return 1;
	}
	
}
