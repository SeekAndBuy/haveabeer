package com.seekandbuy.haveabeer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class BeerCharacteristic extends Characteristic{
	
	
	@Id
	@JsonInclude(Include.NON_NULL)
	private Long Id;

	@JsonInclude(Include.NON_NULL)
	private String brand;
		
	@JsonInclude(Include.NON_NULL)
	private double price;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
}
