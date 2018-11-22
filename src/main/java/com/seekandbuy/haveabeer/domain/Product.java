package com.seekandbuy.haveabeer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Product {

	@JsonInclude(Include.NON_NULL)
	private String type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long Id;

	@JsonInclude(Include.NON_NULL)
	private String brand;
	
	@JsonInclude(Include.NON_NULL)
	private String date;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name="address_id")
	@Cascade(CascadeType.PERSIST)
	private Address address;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	private User user;
	
	@JsonInclude(Include.NON_NULL)
	private double price;
	
	
	public String getType() {
		return type;
	}

	public void setType(String tipo) {
		this.type = tipo;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String marca) {
		this.brand = marca;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String data) {
		this.date = data;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
