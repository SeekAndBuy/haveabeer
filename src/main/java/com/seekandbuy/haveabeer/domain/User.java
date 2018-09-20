/*User*/
package com.seekandbuy.haveabeer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class User {
	@JsonInclude(Include.NON_NULL)
	private String name;
	
	public List<Promotion> promotions;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long Id;

	@JsonInclude(Include.NON_NULL)
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	private Address address;
	
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address endereco) {
		this.address = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telefone) {
		this.phone = telefone;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
