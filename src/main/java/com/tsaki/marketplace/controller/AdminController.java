package com.tsaki.marketplace.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tsaki.marketplace.dao.CategoryDAO;
import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dto.Category;
import com.tsaki.marketplace.dto.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showAdminProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		mv.addObject("product", newProduct);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title" , "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		
		logger.info(mProduct.toString());
		productDAO.add(mProduct);
		return "redirect:/admin/products?operation=product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
}
