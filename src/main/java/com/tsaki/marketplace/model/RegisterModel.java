package com.tsaki.marketplace.model;

import java.io.Serializable;

import com.tsaki.marketplace.dto.Address;
import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.User;
import com.tsaki.marketplace.dto.Wishlist;

public class RegisterModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private Address billing;
	private Cart cart;
	private Wishlist wishlist;
	private BankAccount bankAccount;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}
