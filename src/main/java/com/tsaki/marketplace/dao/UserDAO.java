package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.User;


public interface UserDAO {
	
	User get(int id);
	boolean addUser(User user);
	User getByEmail(String email);
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);

}
