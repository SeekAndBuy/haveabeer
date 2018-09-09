/*User*/
package com.seekandbuy.haveabeer.domain;
//-Descomentar a linha 4 e 9 apos correão dos erros das depedencias
//import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@Entity
public class User {
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTY)
	@JsonInclude(Include.NON_NULL)
	private Long Id;
	
	@JsonInclude(Include.NON_NULL)
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	private String endereco;
	
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
