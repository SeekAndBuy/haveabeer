package com.seekandbuy.haveabeer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Promotion {

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
	private String address;

	//Imagem?
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String endereco) {
		this.address = endereco;
	}
	
}
