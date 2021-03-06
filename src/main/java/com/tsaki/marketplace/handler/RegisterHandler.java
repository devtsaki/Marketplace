package com.tsaki.marketplace.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tsaki.marketplace.controller.PageController;
import com.tsaki.marketplace.dao.UserDAO;
import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.User;
import com.tsaki.marketplace.dto.Wishlist;
import com.tsaki.marketplace.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
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
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			user.setWishlist(wishlist);
		} else {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setUser(user);
			user.setBankAccount(bankAccount);
			logger.info(bankAccount.toString());
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.addUser(user);
		logger.info(user.toString());
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	
	
}
