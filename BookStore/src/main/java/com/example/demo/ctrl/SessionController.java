package com.example.demo.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.CartItem;

@RestController
@RequestMapping("/session")
public class SessionController {

	 	@GetMapping("/")
	    public List<CartItem> index(Model model, HttpSession session) {
	        List<CartItem> cart = getCart(session);
	        model.addAttribute("cart", cart);
	        model.addAttribute("sessionId", session.getId());
	        return cart;
	    }

	    @PostMapping("/addToCart")
	    public String addToCart (@RequestBody CartItem item, HttpServletRequest request) {
	        List<CartItem> cart = getCart(request.getSession());
	        if (item != null) {
	        	cart.add(item);
	            request.getSession().setAttribute("cart", cart);
	        }
	        return "added";
	    }
	    
	    @SuppressWarnings("unchecked")
		@GetMapping("/cart")
	    private List<CartItem> getCart(HttpSession session) {
	        List<CartItem> mycart = (List<CartItem>) session.getAttribute("cart");
	        if (mycart == null) {
	        	mycart = new ArrayList<>();
	        }
	        return mycart;
	    }
	    
}
