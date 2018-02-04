package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.User;


public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	boolean updateCart(Cart cart);

}
