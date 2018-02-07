package com.tsaki.marketplace.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Stock implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please enter Product Name!")
	private String name;
	@NotBlank(message="Please enter Brand Name!")
	private String brand;
	@JsonIgnore
	@NotBlank(message="Please enter Product Description!")
	private String description;
	
	@Column(name = "unit_price")
	@Min(value = 1, message = "Price isn't right!")
	private double unitPrice;
	
	@Min(value = 0,  message = "Really? Negative quantity?")
	private int quantity;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active + ", categoryId="
				+ categoryId + ", userId=" + userId + "]";
	}
	
	
}
