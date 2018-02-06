package com.tsaki.marketplace.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address!")
	private String addressLineOne;
	
	@NotBlank(message = "Please enter city!")
	private String city;
	
	@NotBlank(message = "Please enter country!")
	private String country;
	
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code!")
	private String postalCode;
	
	private boolean shipping;
	private boolean billing;
	
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

	public String getAddressLineOne() {
		return addressLineOne;
	}
	
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public boolean isShipping() {
		return shipping;
	}
	
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	
	public boolean isBilling() {
		return billing;
	}
	
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
}
