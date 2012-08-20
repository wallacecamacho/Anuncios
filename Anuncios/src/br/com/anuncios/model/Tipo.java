package br.com.anuncios.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tipo", catalog="saogoncaloanuncios")
public class Tipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3976959263607671797L;
	private Integer idTipo;
	private String desctTipo;
	private Indice indice;
	private List<Anuncio> anuncios = new ArrayList<Anuncio>();
	
	public Tipo() {
		super();		
	}

	public Tipo(Integer idTipo, String desctTipo) {
		super();
		this.idTipo = idTipo;
		this.desctTipo = desctTipo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTipo", unique = true, nullable=false)
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	@Column(name="descTipo", nullable=false, length=60 )
	@Length(max=60)	
	@NotBlank
	@NotEmpty
	public String getDesctTipo() {
		return desctTipo;
	}

	public void setDesctTipo(String desctTipo) {
		this.desctTipo = desctTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="indice_idIndice" , nullable=false)
	@NotEmpty
	public Indice getIndice() {
		return indice;
	}

	public void setIndice(Indice indice) {
		this.indice = indice;
	}

	@OneToMany(mappedBy="tipo", fetch = FetchType.LAZY)
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
	
	
	
	
}
