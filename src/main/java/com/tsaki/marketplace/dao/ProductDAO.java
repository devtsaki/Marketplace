package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	boolean save(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	List<Product> getProductsByParam(String param, int count);
	
}
