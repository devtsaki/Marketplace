package com.tsaki.marketplace.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsaki.marketplace.dao.UserDAO;
import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tsaki.marketplace");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("FTest");
//		user.setLastName("LTest");
//		user.setEmail("test@test.com");
//		user.setContactNumber("22233344455");
//		user.setRole("USER");
//		user.setPassword("test");
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("Amalias 60, Test123");
//		address.setCity("Athens");
//		address.setCountry("Greece");
//		address.setPostalCode("11212");
//		address.setBilling(true);
//		
//		address.setUserId(user.getId());
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		if (user.getRole().equals("USER")) {
//			cart = new Cart();
//			cart.setUser(user);
//			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//			
//			address = new Address();
//			address.setAddressLineOne("Bari 61, Test124");
//			address.setAddressLineTwo("Dipla 12, Test125");
//			address.setCity("Patra");
//			address.setCountry("Greece");
//			address.setPostalCode("33212");
//			address.setShipping(true);
//			
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		}
//		
//	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("FTest");
//		user.setLastName("LTest");
//		user.setEmail("test@test.com");
//		user.setContactNumber("22233344455");
//		user.setRole("USER");
//		user.setPassword("test");
//		
//		
//		if (user.getRole().equals("USER")) {
//			cart = new Cart();
//			cart.setUser(user);
//			user.setCart(cart);
//		}
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//	}
	
//	@Test
//	public void testUpdateCart() {
//		user = userDAO.getByEmail("test@test.com");
//		cart = user.getCart();
//		cart.setGrandTotal(1000);
//		cart.setCartLines(2);
//		
//		assertEquals("Failed to update cart", true, userDAO.updateCart(cart));
//	}

//	@Test
//	public void testAddAddress() {
//		user = new User();
//		user.setFirstName("FTest");
//		user.setLastName("LTest");
//		user.setEmail("test@test.com");
//		user.setContactNumber("22233344455");
//		user.setRole("USER");
//		user.setPassword("test");
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("Amalias 60, Test123");
//		address.setAddressLineTwo("Over Oven");
//		address.setCity("Athens");
//		address.setCountry("Greece");
//		address.setPostalCode("11212");
//		address.setBilling(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add address", true, userDAO.addAddress(address));
//		
//		address = new Address();
//		address.setAddressLineOne("Bari 61, Test124");
//		address.setAddressLineTwo("Dipla 12, Test125");
//		address.setCity("Patra");
//		address.setCountry("Greece");
//		address.setPostalCode("33212");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//	}
	
//	@Test
//	public void testAddAddress() {
//		user = userDAO.getByEmail("test@test.com");
//		address = new Address();
//		address.setAddressLineOne("Koropi 161, Test1234");
//		address.setAddressLineTwo("Dipla Airport Test125");
//		address.setCity("Athens");
//		address.setCountry("Greece");
//		address.setPostalCode("178212");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//	}

	@Test
	public void testGetAddresses() {
		user = userDAO.getByEmail("test@test.com");
		assertEquals("Failed to get list of addresses or size doesn't match", 2, userDAO.listShippingAddresses(user).size());
		assertEquals("Failed to get list of billing address", "Athens" , userDAO.getBillingAddress(user).getCity());
	}

}
