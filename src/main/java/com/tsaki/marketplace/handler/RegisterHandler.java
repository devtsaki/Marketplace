package com.tsaki.marketplace.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsaki.marketplace.dao.UserDAO;
import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.User;
import com.tsaki.marketplace.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO; 
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		User user = model.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userDAO.addUser(user);
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
}
