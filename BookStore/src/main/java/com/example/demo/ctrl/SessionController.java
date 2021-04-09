package com.example.demo.ctrl;

import com.example.demo.beans.CartItem;
import com.example.demo.beans.Payment;
import com.example.demo.beans.SessionItem;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/*
    Controller to handle session information
    Used for persistence in cart and user tracking
*/
@RestController
@RequestMapping("/session")
public class SessionController {

		@Autowired
		SessionService ss;


		//get index of model and session
	 	@GetMapping("/")
	    public List<SessionItem> index(Model model, HttpSession session) {
	        return ss.index(model, session);
	    }


	    //get current cart
	 	@GetMapping("/cart")
	    private List<SessionItem> getCart(HttpSession session) {
	        return ss.convertCartToSessionItem(ss.getCart(session));
	 		
	    }

	    //add to users cart
	    @PostMapping("/addToCart")
	    public List<SessionItem> addToCart (@RequestBody CartItem item, HttpServletRequest request) {
	        return ss.addToCart(item, request);
	    	//return item;
	    }


	    //delete from users cart
	    @DeleteMapping("/delete")
	    public List<SessionItem> deleteItem(@RequestBody CartItem bookID, HttpServletRequest request)
	    {
	    	System.out.println(bookID.getBookID());
	    	System.out.println(bookID.getBookQuantity());
	    	System.out.println(request.toString());
	    	return ss.removeItem(bookID, request);
	    }

	    //update quantity of item in cart
	    @PostMapping("/updateQuantity")
	    public List<SessionItem> updateItemQuantity(@RequestBody CartItem item, HttpServletRequest request)
	    {
	    	return ss.updateItemQuantity(item, request);
	    }

	    //checkout from cart
	    @PostMapping("/checkout")
	    public String checkout(@RequestBody Payment item, HttpServletRequest request)
	    {
	    	return ss.checkout(item, request);
	    }
}
