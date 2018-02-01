package com.tsaki.marketplace.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dto.Product;

public class ProductTestCase {
	

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tsaki.marketplace");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct() {
//		product = new Product();
//		product.setName("Oppo A52");
//		product.setBrand("Oppo");
//		product.setDescription("This is an Oppo description");
//		product.setUnitPrice(350.34);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		assertEquals("Something went wrong while inserting product", true, productDAO.add(product));
//		
//		product = productDAO.get(2);
//		product.setName("iPhone 7");
//		assertEquals("Something went wrong while updating product", true, productDAO.update(product));
//		
//		assertEquals("Something went wrong while deleting product", true, productDAO.delete(product));
//		
//		assertEquals("Something went wrong while getting a list of products from table!", 6, productDAO.list().size());
//		
//	}
	
//	@Test
//	public void testListActiveproducts() {
//		assertEquals("Something went wrong while getting a list of active products from table!", 5, productDAO.listActiveProducts().size());
//	}
//	
//	@Test
//	public void testListActiveproductsByCategory() {
//		assertEquals("Something went wrong while getting a list of active products from table!", 2, productDAO.listActiveProductsByCategory(3).size());
//		assertEquals("Something went wrong while getting a list of active products from table!", 2, productDAO.listActiveProductsByCategory(1).size());
//	}
//	
//	@Test
//	public void testLatestActiveproducts() {
//		assertEquals("Something went wrong while getting a list of active products from table!", 3, productDAO.getLatestActiveProducts(3).size());
//	}
}
