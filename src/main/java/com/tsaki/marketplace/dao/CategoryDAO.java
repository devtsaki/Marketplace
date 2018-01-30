package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	
	List<Category> list();
	Category get(int id);
	
}
