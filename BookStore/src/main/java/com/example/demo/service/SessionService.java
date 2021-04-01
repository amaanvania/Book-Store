package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.example.demo.beans.CartItem;

@Service
public class SessionService {

	public List<CartItem> addToCart(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
        if (item != null) {
        	cart.add(item);
            request.getSession().setAttribute("cart", cart);
        }
        return cart;
	}
	
	public List<CartItem> removeItem(CartItem item, HttpServletRequest request)
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
		return cart;
	}

	public List<CartItem> updateItemQuantity(CartItem item, HttpServletRequest request)
	{
		List<CartItem> cart = getCart(request.getSession());
		if (item != null) {
        	
			for (int i = 0 ; i < cart.size(); i++)
			{
				if (item.getbookName().equals(cart.get(i).getbookName()))
				{
					cart.get(i).setQuantity(item.getQuantity());
					break;
				}
			}
            request.getSession().setAttribute("cart", cart);
        }
		return cart;
	}
	
	public List<CartItem> index(Model model, HttpSession session) {
        List<CartItem> cart = getCart(session);
        model.addAttribute("cart", cart);
        model.addAttribute("sessionId", session.getId());
        return cart;
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
