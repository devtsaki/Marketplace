package com.tsaki.marketplace.model;

import java.io.Serializable;

import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.Cart;
import com.tsaki.marketplace.dto.Wishlist;

public class UserModel implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullName;
	private String email;
	private String role;
	private Cart cart;
	private Wishlist wishlist;
	private BankAccount bankAccount;;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
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
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", email=" + email + ", role=" + role + ", cart="
				+ cart + "]";
	}

}
