package com.diego.petshop.domain.enuns;

public enum SituacaoPagamento {

	QUITADO(1, "Quitado"), CANCELADO(2, "Cancelado"), PENDENTE(3, "Pendente");

	private int code;
	private String descricao;

	private SituacaoPagamento(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public static SituacaoPagamento toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (SituacaoPagamento sp : SituacaoPagamento.values()) {
			if (code.equals(sp.getCode())) {
				return sp;
			}
		}
		throw new IllegalArgumentException();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
