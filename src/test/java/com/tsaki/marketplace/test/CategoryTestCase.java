package com.tsaki.marketplace.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsaki.marketplace.dao.CategoryDAO;
import com.tsaki.marketplace.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tsaki.marketplace");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testCRUDCategory() {
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is a laptop description");
//		category.setImageURL("CAT_1.png");
//		assertEquals("Succesfully added a category inside table", true, categoryDAO.add(category));
//		
//		category = new Category();
//		category.setName("Television");
//		category.setDescription("This is a TV description");
//		category.setImageURL("CAT_2.png");
//		assertEquals("Something went wrong while adding a category inside table", true, categoryDAO.add(category));
//		
//		category = categoryDAO.get(2);
//		category.setName("TV");
//		assertEquals("Something went wrong while updated a single category in table!", true, categoryDAO.update(category));
//		
//		assertEquals("Something went wrong while deleting a single category in table!", true, categoryDAO.delete(category));
//		
//		assertEquals("Something went wrong while getting list of categories from table!", 4, categoryDAO.list().size());
//		
//	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is a laptop description");
//		category.setImageURL("CAT_105.png");
//		
//		assertEquals("Succesfully added a category inside table", true, categoryDAO.add(category));
//		
//	}

//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(2);
//		assertEquals("Succesfully got a single category from table!", "Laptop", category.getName());
//	}
	
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(2);
//		category.setName("Laptop");
//		assertEquals("Succesfully updated a single category in table!", true, categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(2);
//		assertEquals("Succesfully deleted a single category in table!", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		assertEquals("Succesfully got list of categories from table!", 2, categoryDAO.list().size());
//	}
	
}
