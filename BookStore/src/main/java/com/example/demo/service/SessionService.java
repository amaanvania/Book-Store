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
import com.example.demo.beans.SessionItem;
import com.example.demo.dao.BookDAO;
import com.example.demo.beans.SessionItem;

@Service
public class SessionService {

	@Autowired
	BookDAO bd;
	
	public List<SessionItem> addToCart(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
        if (item != null) {
        	Book b = null;
        	
        	cart.add(item);
            request.getSession().setAttribute("cart", cart);
        }
        return convertCartToSessionItem(cart);
	}
	
	public List<SessionItem> removeItem(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
		if (item != null) {
        	int index = cart.indexOf(item);
        	if (index != -1)
        	{
        		cart.remove(index);
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
			//	if (item.getBookID().equals(cart.get(i).getBookID()))
			//	{
			//		cart.get(i).setBookQuantity(item.getBookQuantity());
			//		break;
			//	}
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
