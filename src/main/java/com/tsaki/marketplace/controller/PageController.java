package com.tsaki.marketplace.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tsaki.marketplace.dao.CategoryDAO;
import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dto.Category;
import com.tsaki.marketplace.dto.Product;
import com.tsaki.marketplace.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value= {"/", "home", "index"})
	public ModelAndView index() {	
		ModelAndView mv = new ModelAndView("page");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {	
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {	
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {	
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {	
		ModelAndView mv = new ModelAndView("page");
		
		//CategoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//Categories list
		mv.addObject("categories", categoryDAO.list());
		//single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if (product == null) {
			throw new ProductNotFoundException();
		}
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product" , product);
		mv.addObject("userClickShowProduct" , true);
		return mv;
	}
	
	@RequestMapping(value= "/login")
	public ModelAndView login(@RequestParam(name = "error", required=false) String error,
			@RequestParam(name = "logout", required=false) String logout) {	
		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("message", "Invalid Username or Password");
		}
		if (logout != null) {
			mv.addObject("logout", "Succesfully logged out!");
		}
		mv.addObject("title", "Login Page");
		return mv;
	}
	
	@RequestMapping(value= "/access-denied")
	public ModelAndView accessDenied() {	
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied!");
		mv.addObject("errorTitle", "You shall not pass!");
		mv.addObject("errorDescription", "It is dangerous to go here alone! Take a rock and leave!");
		return mv;
	}
	
	@RequestMapping(value= "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value = "greeting", required=false)String greeting) {
//		if (greeting == null) {
//			greeting = "default";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;	
//	}
	
//	@RequestMapping(value="/test/{greeting}")
//	public ModelAndView test(@PathVariable("greeting") String greeting) {
//		if (greeting == null) {
//			greeting = "default";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;	
//	}
	
}
