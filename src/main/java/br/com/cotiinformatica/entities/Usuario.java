package br.com.cotiinformatica.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //define o javabean como entidade do banco
@Table(name = "TBL_USUARIO") //define o nome da tabela do banco de dados
public class Usuario implements Serializable {

	private static final long serialVersionUID = 2924868738494981100L;

	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	@Column(name = "COD_USU") //nome da coluna na tabela
	private Integer idUsuario;
	
	@Column(name = "NOME_USU", length = 150, nullable = false) //coluna na tabela
	private String nome;
	
	@Column(name = "EMAIL_USU", length = 100, nullable = false, unique = true) //coluna na tabela
	private String email;
	
	@Column(name = "SENHA_USU", length = 50, nullable = false) //coluna na tabela
	private String senha;
	
	@Temporal(TemporalType.DATE) //salva somente data no banco de dados
	@Column(name = "DTCRIACAO_USU", nullable = false) //coluna na tabela
	private Date dataCriacao;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, Date dataCriacao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", dataCriacao=" + dataCriacao + "]";
	}

	@Override
	public boolean equals(Object obj) {
	
		if(obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return this.idUsuario.equals(usuario.getIdUsuario());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.idUsuario.hashCode();
	}
}












