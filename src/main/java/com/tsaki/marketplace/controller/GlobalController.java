package com.tsaki.marketplace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tsaki.marketplace.dao.UserDAO;
import com.tsaki.marketplace.dto.User;
import com.tsaki.marketplace.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	private User user = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userDAO.getByEmail(authentication.getName());
			if (user != null) {
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if (userModel.getRole().equals("USER")) {
					userModel.setCart(user.getCart());
					userModel.setWishlist(user.getWishlist());
				}
				
				session.setAttribute("userModel", userModel);
				return userModel;
				
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
	
}
