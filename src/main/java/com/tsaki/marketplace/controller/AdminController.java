package com.tsaki.marketplace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsaki.marketplace.dao.BankAccountDAO;
import com.tsaki.marketplace.dao.CategoryDAO;
import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dao.StockDAO;
import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.Category;
import com.tsaki.marketplace.dto.Product;
import com.tsaki.marketplace.dto.Stock;
import com.tsaki.marketplace.model.UserModel;
import com.tsaki.marketplace.service.StockService;
import com.tsaki.marketplace.util.FileUploadUtility;
import com.tsaki.marketplace.validator.ProductValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showAdminProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		mv.addObject("product", newProduct);
		UserModel user = (UserModel) session.getAttribute("userModel");
		BankAccount bankAccount = bankAccountDAO.get(user.getId());
		mv.addObject("bankAccount", bankAccount);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if (operation.equals("category")) {
				mv.addObject("message", "Category Created Successfully!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, 
			BindingResult results, Model model, HttpServletRequest request) {
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title" , "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		mProduct.setActive(true);
		logger.info(mProduct.toString());
		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/admin/products?operation=product";
	}
	
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title" , "Manage Products");
		Product newProduct = productDAO.get(id);
		newProduct.setSupplierId(1);
		mv.addObject("product", newProduct);
		
		return mv;
	}
	
	@RequestMapping(value="/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive)? "Product with id " + product.getId() + " has been succesfully deactivated" : "Product with id "
			+ product.getId() + " has been succesfully activated";
	}
	
	@RequestMapping(value="/stock/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleStockActivation(@PathVariable("id") int id) {
		Stock stock = stockDAO.get(id);
		logger.info("Admin stock " + stock.toString());
		stockService.createProduct(stock);
		stockService.chargeAdmin(stock);
		stockService.paySupplier(stock);
		stockService.deleteStock(stock);
		return "Stock with has been succesfully added to products";
	}
	
	@RequestMapping(value="/stock/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String handleSellerStockDeletion(@PathVariable("id") int id) {
		stockService.deleteStock(stockDAO.get(id));
		return "Stock Product has been succesfully removed";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/admin/products/?operation=category";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
