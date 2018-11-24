package com.seekandbuy.haveabeer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.seekandbuy.domain.Product;


@Entity
public class Beer extends Product {
	
	@JsonInclude(Include.NON_NULL)
	@Cascade(CascadeType.PERSIST)
	@ManyToOne
	private BeerCharacteristic beerCharacteristic;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	private BeerUser user;
	
	public BeerCharacteristic getBeerCharacteristic() {
		return beerCharacteristic;
	}
	
	public void setBeerCharacteristic(BeerCharacteristic beerCharacteristic) {
		this.beerCharacteristic = beerCharacteristic;
	}
	
	public BeerUser getUser() {
		return user;
	}
	
	public void setUser(BeerUser user) {
		this.user = user;
	}

	
	
}
