package br.com.cotiinformatica.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.cotiinformatica.enums.PrioridadeCompromisso;
import br.com.cotiinformatica.enums.TipoCompromisso;

@Entity
@Table(name = "TBL_COMPROMISSO")
public class Compromisso implements Serializable {

	private static final long serialVersionUID = -1789505044084135825L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_COMP")
	private Integer idCompromisso;
	
	@Column(name = "NOME_COMP", length = 150, nullable = false)
	private String nome;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATA_COMP", nullable = false)
	private Date data;
	
	@Column(name = "HORA_COMP", length = 5, nullable = false)
	private String hora;
		
	@Column(name = "DESCRICAO_COMP", length = 1000, nullable = false)
	private String descricao;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "TIPO_COMP", nullable = false)
	private TipoCompromisso tipo;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "PRIORIDADE_COMP", nullable = false)
	private PrioridadeCompromisso prioridade;
	
	//Multiplicidades: OneToOne, OneToMany, ManyToOne, ManytoMany
	@ManyToOne //Muitos Compromissos para 1 Usuario
	@JoinColumn(name = "COD_USU", nullable = false)
	private Usuario usuario;

	public Compromisso() {
		// TODO Auto-generated constructor stub
	}

	public Compromisso(Integer idCompromisso, String nome, Date data, String hora, String descricao,
			TipoCompromisso tipo, PrioridadeCompromisso prioridade, Usuario usuario) {
		super();
		this.idCompromisso = idCompromisso;
		this.nome = nome;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.usuario = usuario;
	}

	public Integer getIdCompromisso() {
		return idCompromisso;
	}

	public void setIdCompromisso(Integer idCompromisso) {
		this.idCompromisso = idCompromisso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Compromisso [idCompromisso=" + idCompromisso + ", nome=" + nome + ", data=" + data + ", hora=" + hora
				+ ", descricao=" + descricao + ", tipo=" + tipo + ", prioridade=" + prioridade + ", usuario=" + usuario
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Compromisso) {
			Compromisso compromisso = (Compromisso) obj;
			return this.idCompromisso.equals(compromisso.getIdCompromisso());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.idCompromisso.hashCode();
	}
}
