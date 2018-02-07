package com.tsaki.marketplace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.tsaki.marketplace.dao.StockDAO;
import com.tsaki.marketplace.dto.Category;
import com.tsaki.marketplace.dto.Stock;
import com.tsaki.marketplace.model.UserModel;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Autowired
	HttpSession session;
	
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView showAdminProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickStock", true);
		mv.addObject("title" , "Sell Products");
		UserModel user = (UserModel) session.getAttribute("userModel");
		Stock newStock = new Stock();
		newStock.setUserId(user.getId());
		logger.info(newStock.toString());
		mv.addObject("stock", newStock);
		if (operation != null) {
			if (operation.equals("stock")) {
				mv.addObject("message", "Stock Product Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public String handleStockSubmission(@ModelAttribute("stock") Stock mStock,
			BindingResult results, Model model, HttpServletRequest request) {
		if (results.hasErrors()) {
			model.addAttribute("userClickStock", true);
			model.addAttribute("title" , "Sell Products");
			model.addAttribute("message", "Validation failed for Stock Submission!");
			return "page";
		}
		logger.info(mStock.toString());
		
		if (mStock.getId() == 0) {
			
			stockDAO.add(mStock);
		}
		else {
			stockDAO.update(mStock);
		}
		
		return "redirect:/supplier/stock?operation=stock";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
}
