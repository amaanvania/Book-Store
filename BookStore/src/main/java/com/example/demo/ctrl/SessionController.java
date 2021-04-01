package com.example.demo.ctrl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.beans.CartItem;
import com.example.demo.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {

		@Autowired
		SessionService ss;
		
	 	@GetMapping("/")
	    public List<CartItem> index(Model model, HttpSession session) {
	        return ss.index(model, session);
	    }
	 	
	 	@GetMapping("/cart")
	    private List<CartItem> getCart(HttpSession session) {
	        return ss.getCart(session);
	    }
	 	
	    @PostMapping("/addToCart")
	    public List<CartItem> addToCart (@RequestBody CartItem item, HttpServletRequest request) {
	        return ss.addToCart(item, request);
	    }
	    
	    @PostMapping("/delete")
	    public List<CartItem> deleteItem(@RequestBody CartItem item, HttpServletRequest request)
	    {
	    	return ss.removeItem(item, request);
	    }
	    
	    @PostMapping("/updateQuantity")
	    public List<CartItem> updateItemQuantity(@RequestBody CartItem item, HttpServletRequest request)
	    {
	    	return ss.updateItemQuantity(item, request);
	    }
}
