package com.lm.app.utils;

import javax.servlet.http.HttpServletRequest;

import com.lm.app.model.CartInfo;

public class Utils {
	 
       // This method returns the CartInfo object (i.e., the cart) stored in the current session.
	   public static CartInfo getCartInSession(HttpServletRequest request) {
	      // Fetch the "myCart" attribute from the session.
	      CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
	     
	      // If "myCart" is not present in the session, create a new CartInfo object and add it to the session.
	      if (cartInfo == null) {
	         cartInfo = new CartInfo();
	         // Stores the newly created cart in the session with the name "myCart".
	         request.getSession().setAttribute("myCart", cartInfo);
	      }
	 
	      return cartInfo;
	   }
	 
	   // This method removes the cart ("myCart") from the current session.
	   public static void removeCartInSession(HttpServletRequest request) {
	      request.getSession().removeAttribute("myCart");
	   }
	 
	   // This method stores the last ordered cart in the current session with the name "lastOrderedCart".
	   public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
	      request.getSession().setAttribute("lastOrderedCart", cartInfo);
	   }
	 
	   // This method retrieves the last ordered cart ("lastOrderedCart") from the current session.
	   public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
	      return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	   }
	    
	}
