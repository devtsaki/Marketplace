package com.tsaki.marketplace.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password doesn't match!").build());
			transitionValue = "failure";
		}
		
		if (userDAO.getByEmail(user.getEmail()) != null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is being used!").build());
			transitionValue = "failure";
			transitionValue = "failure";
		}
		return transitionValue;
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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.addUser(user);
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	
	
}
