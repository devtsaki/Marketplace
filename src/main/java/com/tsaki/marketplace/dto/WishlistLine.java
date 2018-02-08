package com.tsaki.marketplace.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_line")
public class WishlistLine implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product product;
	
	@Column(name = "wishlist_id")
	private int wishlistId;
	
	@Column(name = "product_count")
	private int productCount;
	
	private double total;
	
	@Column(name = "buying_price")
	private double buyingPrice;
	
	@Column(name = "is_available", columnDefinition = "boolean default true")
	private boolean available = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	@Override
	public String toString() {
		return "WishlistLine [id=" + id + ", product=" + product + ", wishlistId=" + wishlistId + ", productCount="
				+ productCount + ", total=" + total + ", buyingPrice=" + buyingPrice + "]";
	}
	
}
