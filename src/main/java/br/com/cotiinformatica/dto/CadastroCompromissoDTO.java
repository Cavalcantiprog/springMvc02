package br.com.cotiinformatica.dto;

import br.com.cotiinformatica.enums.PrioridadeCompromisso;
import br.com.cotiinformatica.enums.TipoCompromisso;

public class CadastroCompromissoDTO {

	private String nome;
	private String data;
	private String hora;
	private String descricao;
	private TipoCompromisso tipo;
	private PrioridadeCompromisso prioridade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoCompromisso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCompromisso tipo) {
		this.tipo = tipo;
	}

	public PrioridadeCompromisso getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeCompromisso prioridade) {
		this.prioridade = prioridade;
	}

}


