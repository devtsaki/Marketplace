package com.tsaki.marketplace.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wishlist implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User user;
	
	
	@Column(name = "wishlist_lines")
	private int wishlistLines;

	@Column(name = "is_available")
	private boolean available = true;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public int getWishlistLines() {
		return wishlistLines;
	}


	public void setWishlistLines(int wishlistLines) {
		this.wishlistLines = wishlistLines;
	}

	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", user=" + user + ", wishlistLines=" + wishlistLines + "]";
	}
	
}
