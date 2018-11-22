package com.seekandbuy.haveabeer.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Beer extends Product {
	
	@JsonInclude(Include.NON_NULL)
	@Cascade(CascadeType.PERSIST)
	private BeerCharacteristic beerCharacteristic;
	
	public BeerCharacteristic getBeerCharacteristic() {
		return beerCharacteristic;
	}
	
	public void setBeerCharacteristic(BeerCharacteristic beerCharacteristic) {
		this.beerCharacteristic = beerCharacteristic;
	}
	
	
}
