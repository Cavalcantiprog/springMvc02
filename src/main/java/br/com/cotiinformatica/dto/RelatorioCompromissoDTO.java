package br.com.cotiinformatica.dto;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.entities.Compromisso;
import br.com.cotiinformatica.entities.Usuario;

public class RelatorioCompromissoDTO {

	private Date dataInicio;
	private Date dataFim;
	
	private Usuario usuario;
	private List<Compromisso> compromissos;
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date datFim) {
		this.dataFim = datFim;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Compromisso> getCompromissos() {
		return compromissos;
	}
	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}
	
}
