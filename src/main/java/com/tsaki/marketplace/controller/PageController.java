package com.tsaki.marketplace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tsaki.marketplace.dao.CategoryDAO;
import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dto.Category;
import com.tsaki.marketplace.dto.Product;

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
	public ModelAndView showSingleProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product" , product);
		mv.addObject("userClickShowProduct" , true);
		return mv;
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
