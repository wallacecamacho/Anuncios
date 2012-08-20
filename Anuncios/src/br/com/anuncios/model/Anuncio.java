package br.com.anuncios.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="anuncio", catalog="saogoncaloanuncios")
public class Anuncio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3720427468624721438L;
	private Integer idAnuncio;
	//@NotNull
	//@Valid
	private Tipo tipo;
	private Bairro bairro;
	private String nome;
	private String descricao;
	private String descricaoCompleta;
	private Date dataExpAnuncio;
	private String url;
	private Integer ddd;
	private Integer telefone;
	private String email;
	private Double lat;
	private Double lgt;
	private Boolean ativo;
	private Boolean destaque;
	private String logoAnuncio;
	private String uf;
	private Integer cidade;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String cep;
	private Date dataAtualizacao;
	private Date dataInclusao;
	private String usuario;
	
	
	public Anuncio() {
	}

	public Anuncio(int idanuncio, Tipo tipo) {
		this.idAnuncio = idanuncio;
		this.tipo = tipo;
	}

	public Anuncio(int idAnuncio, Tipo tipo, String descricao,
			Date dataExpAnuncio, String url, Integer ddd, Integer telefone,
			String email, Double lat, Double lgt) {
		this.idAnuncio = idAnuncio;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataExpAnuncio = dataExpAnuncio;
		this.url = url;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
		this.lat = lat;
		this.lgt = lgt;
	}
	
	@Id
	@Column(name="idAnuncio", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdAnuncio() {
		return idAnuncio;
	}
	
	public void setIdAnuncio(Integer idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_idtipo", nullable=false)	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Column(name="nome", length=100)
	@Length(max=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="descricao", length=200)
	@Length(max=200)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name="descricaoCompleta", length=400)
	@Length(max=400)
	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	@Column(name = "dataExpAnuncio")
	@Temporal(TemporalType.DATE)
	public Date getDataExpAnuncio() {
		return dataExpAnuncio;
	}
	
	public void setDataExpAnuncio(Date dataExpAnuncio) {
		this.dataExpAnuncio = dataExpAnuncio;
	}
	
	@Column(name="url", length=300)
	@Length(max=300)
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="ddd", length=2)
	//@Length(max=2)
	@Digits(fraction = 0, integer = 2)
	public Integer getDdd() {
		return ddd;
	}
	
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	
	@Column(name="telefone", length=8)
	@Digits(fraction = 0, integer = 8)
	public Integer getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="email" , length=200)
	@Length(max=200)
	@Email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="lat", precision=10, scale=6)
	public Double getLat() {
		return lat;
	}
	
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	@Column(name="lgt", precision=10, scale=6)
	public Double getLgt() {
		return lgt;
	}
	
	public void setLgt(Double lgt) {
		this.lgt = lgt;
	}

	@Column(name="ativo")
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name="destaque")
	public Boolean getDestaque() {
		return destaque;
	}

	public void setDestaque(Boolean destaque) {
		this.destaque = destaque;
	}

	@Column(name="logoAnuncio" , length=100)
	@Length(max=200)
	public String getLogoAnuncio() {
		return logoAnuncio;
	}

	public void setLogoAnuncio(String logoAnuncio) {
		this.logoAnuncio = logoAnuncio;
	}

	@Column(name="uf" , length=2)
	@Length(max=2)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(name="cidade_idcidade")
	@Digits(fraction = 0, integer = 11)
	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bairro_idBairro")
	@NotNull
	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="endereco" , length=125)
	@Length(max=125)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name="numero", length=8)
	//@Length(max=8)
	@Digits(fraction = 0, integer = 8)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name="complemento" , length=125)
	@Length(max=125)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name="cep" , length=8)
	@Length(max=8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "dataAtualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Column(name = "dataInclusao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Column(name="usuario" , length=45)
	@Length(max=45)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
		
	
}
