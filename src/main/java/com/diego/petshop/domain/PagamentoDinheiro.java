package com.diego.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.diego.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagamentoDinheiro extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Double desconto;

	public PagamentoDinheiro() {
	}

	public PagamentoDinheiro(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Date dataVencimento, Double desconto) {
		super(id, valor, situacaoPagamento, servico);
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
