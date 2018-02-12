package com.tsaki.marketplace.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsaki.marketplace.dao.BankAccountDAO;
import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dao.StockDAO;
import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.Product;
import com.tsaki.marketplace.dto.Stock;

@Service("stockService")
@Transactional
public class StockService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(StockService.class);


	
	public void createProduct(Stock stock) {
		Product product  = new Product();
		product.setActive(false);
		product.setName(stock.getName());
		product.setBrand(stock.getBrand());
		product.setDescription(stock.getDescription());
		product.setQuantity(stock.getQuantity());
		product.setCategoryId(stock.getCategoryId());
		product.setSupplierId(stock.getUserId());
		product.setUnitPrice(stock.getUnitPrice() * 3);
		productDAO.save(product);
		logger.info("Save product");
	}
	
	public void chargeAdmin(Stock stock) {
		BankAccount bankAccount = bankAccountDAO.get(1);
		bankAccount.setAmount(bankAccount.getAmount() - (stock.getUnitPrice() * stock.getQuantity()));
		bankAccountDAO.updateAccount(bankAccount);
		logger.info("Charge Admin");
	}
	
	public void paySupplier(Stock stock) {
		BankAccount bankAccount = bankAccountDAO.get(stock.getUserId());
		bankAccount.setAmount(bankAccount.getAmount() + (stock.getUnitPrice() * stock.getQuantity()));
		bankAccountDAO.updateAccount(bankAccount);
		logger.info("Pay supplier");

	}
	
	public void deleteStock(Stock stock) {
		stockDAO.delete(stock);
		logger.info("Delete stock");
	}
}
