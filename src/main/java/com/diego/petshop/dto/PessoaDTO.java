package com.diego.petshop.dto;

import java.io.Serializable;

import com.diego.petshop.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private String codNacional;

	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.codNacional = pessoa.getCodNacional();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodNacional() {
		return codNacional;
	}

	public void setCodNacional(String codNacional) {
		this.codNacional = codNacional;
	}

}
