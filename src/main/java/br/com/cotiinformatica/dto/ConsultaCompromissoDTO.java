package br.com.cotiinformatica.dto;

import br.com.cotiinformatica.enums.ModoDeExibicao;

public class ConsultaCompromissoDTO {

	private String dataInicio;
	private String dataFim;
	private ModoDeExibicao modoDeExibicao;

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public ModoDeExibicao getModoDeExibicao() {
		return modoDeExibicao;
	}

	public void setModoDeExibicao(ModoDeExibicao modoDeExibicao) {
		this.modoDeExibicao = modoDeExibicao;
	}

}