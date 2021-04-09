package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.beans.Book;
import com.example.demo.beans.CartItem;
import com.example.demo.beans.Payment;
import com.example.demo.beans.SessionItem;
import com.example.demo.dao.BookDAO;

@Service
public class SessionService {

	@Autowired
	BookDAO bd;
	
	@Autowired PaymentService payment;
	@Autowired ProductOrderService pod;
	
	public String validateCartQuantities(List<CartItem> cart)
    {
    	for (int i = 0 ; i < cart.size(); i++)
    	{
    		Book b = bd.getBook(cart.get(i).getBookID());
    		if (cart.get(i).getBookQuantity() > b.getQuantity())
    		{
    			return "Maximum quantity for "+b.getName()+" is: "+ b.getQuantity();
    		}
    	}
    	return "valid";
    }
	
	public String checkout(Payment p, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
		String validCartResponse = validateCartQuantities(cart);
		if (validCartResponse.equals("valid"))
		{
			if (payment.validatePayment(p, request) == 1)
			{
				String response = pod.createOrder(p,cart, request);
				if (response.equals("Order Created"))
				{
					request.getSession().setAttribute("cart", new ArrayList<>());
				}
				return response;
			}
			return "Invalid Payment";
		}
		return validCartResponse;
	}

	public List<SessionItem> addToCart(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
        if (item != null) {
        	int found = -1;
        	for (int i = 0; i < cart.size(); i++)
        	{
        		if (item.getBookID().equals(cart.get(i).getBookID()))
        		{
        			found = i;
        			break;
        		}
        	}
        	if (found == -1)
        	{
            	cart.add(item);
        	}
        	else
        	{
        		int prevQuantity = cart.get(found).getBookQuantity();
        		cart.get(found).setBookQuantity(prevQuantity+item.getBookQuantity());
        	}
            request.getSession().setAttribute("cart", cart);
        }
        return convertCartToSessionItem(cart);
	}
	
	public List<SessionItem> updateItemQuantity(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
		if (item != null) {
        	
			for (int i = 0 ; i < cart.size(); i++)
			{
				if (item.getBookID().equals(cart.get(i).getBookID()))
				{

					cart.get(i).setBookQuantity(item.getBookQuantity());
					break;
				}
			}
            request.getSession().setAttribute("cart", cart);
        }
		return convertCartToSessionItem(cart);
	}

	public List<SessionItem> removeItem(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
		if (item != null) {
			int index = -1;
        	for (int i = 0; i < cart.size(); i++)
        	{
        		if (item.getBookID().equals(cart.get(i).getBookID()))
        		{
        			index = i;
        			break;
        		}
        	}
        	System.out.println(index);
        	if (index != -1)
        	{
        		cart.remove(index);
        	}
            request.getSession().setAttribute("cart", cart);
        }
		return convertCartToSessionItem(cart);
	}

	
	public List<SessionItem> index(Model model, HttpSession session) {
        List<CartItem> cart = getCart(session);
        model.addAttribute("cart", cart);
        model.addAttribute("sessionId", session.getId());
        return convertCartToSessionItem(cart);
    }
	
	public List<SessionItem> convertCartToSessionItem(List<CartItem> cart)
	{
		ArrayList<SessionItem> items = new ArrayList<SessionItem>();
		for (int i = 0 ; i < cart.size(); i++)
		{
			Book b = bd.getBook(cart.get(i).getBookID());
			items.add(new SessionItem(b,cart.get(i).getBookQuantity()));
		}
		return items;
	}
	
	public List<CartItem> getCart(HttpSession session)
	{
		List<CartItem> mycart = (List<CartItem>) session.getAttribute("cart");
        if (mycart == null) {
        	mycart = new ArrayList<>();
        }
        return mycart;
	}
}
