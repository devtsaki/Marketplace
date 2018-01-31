package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Category;

public interface CategoryDAO {

	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
