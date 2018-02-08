package com.tsaki.marketplace.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dao.StockDAO;
import com.tsaki.marketplace.dto.Product;
import com.tsaki.marketplace.dto.Stock;
import com.tsaki.marketplace.model.UserModel;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAdminAllProducts() {
		return productDAO.list();
	}
	
	@RequestMapping("/stock/seller/products")
	@ResponseBody
	public List<Stock> getSellerAllProducts() {
		UserModel user = (UserModel) session.getAttribute("userModel"); 
		return stockDAO.sellerList(user.getId());
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable int id) {		
		return productDAO.listActiveProductsByCategory(id);
	}
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Product> getMostViewedProducts() {		
		return productDAO.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Product> getMostPurchasedProducts() {		
		return productDAO.getProductsByParam("purchases", 5);				
}
	
}
