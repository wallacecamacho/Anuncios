package br.com.anuncios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logradouro", catalog="saogoncaloanuncios")
public class Logradouro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4129026357233685635L;

	@Id
	@Column(name="idLogradouro", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLogradouro;
	
	@Column(name="idUf", length=2)
	private String idUf;
	
	@Column(name="idCidade", length=10)
	private Integer idCidade;
	
	@Column(name="descricaoNaoAbreviada", length=70)
	private String descricaoNaoAbreviada;
	
	@Column(name="descricao", length=125)
	private String descricao;
	
	@Column(name="idBairro", length=10)
	private Integer idBairro;
	
	@Column(name="cep", length=8)
	private Integer cep;
	
	@Column(name="bairroNumSequencial", length=10)
	private Integer bairroNumSequencial;
	
	@Column(name="logradouroComplemento", length=100)
	private String logradouroComplemento;
	
	@Column(name="tipoLogradouro", length=72)
	private String tipoLogradouro;
		
	@Column(name="statusTipoLogradouro", length=1)
	private String statusTipoLogradouro;
	
	@Column(name="descricaoSemAcento", length=70)
	private String descricaoSemAcento;

	public Integer getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(Integer idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public String getIdUf() {
		return idUf;
	}

	public void setIdUf(String idUf) {
		this.idUf = idUf;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getDescricaoNaoAbreviada() {
		return descricaoNaoAbreviada;
	}

	public void setDescricaoNaoAbreviada(String descricaoNaoAbreviada) {
		this.descricaoNaoAbreviada = descricaoNaoAbreviada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getBairroNumSequencial() {
		return bairroNumSequencial;
	}

	public void setBairroNumSequencial(Integer bairroNumSequencial) {
		this.bairroNumSequencial = bairroNumSequencial;
	}

	public String getLogradouroComplemento() {
		return logradouroComplemento;
	}

	public void setLogradouroComplemento(String logradouroComplemento) {
		this.logradouroComplemento = logradouroComplemento;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getStatusTipoLogradouro() {
		return statusTipoLogradouro;
	}

	public void setStatusTipoLogradouro(String statusTipoLogradouro) {
		this.statusTipoLogradouro = statusTipoLogradouro;
	}

	public String getDescricaoSemAcento() {
		return descricaoSemAcento;
	}

	public void setDescricaoSemAcento(String descricaoSemAcento) {
		this.descricaoSemAcento = descricaoSemAcento;
	}
	
	
	
}
