package com.diego.petshop.domain;

import javax.persistence.Entity;

import com.diego.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer parcelas;

	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico,
			Integer parcelas) {
		super(id, valor, situacaoPagamento, servico);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
