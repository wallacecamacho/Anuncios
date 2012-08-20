package br.com.anuncios.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="indice", catalog="saogoncaloanuncios",uniqueConstraints = @UniqueConstraint(columnNames = "idIndice"))
public class Indice implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2826634567131289952L;
	private String idIndice;
	private Set<Tipo> tipos = new HashSet<Tipo>(0);

	
	public Indice(){
		
	}
	
	public Indice(String pIdIndice){
		this.idIndice = pIdIndice;
	}

	@Id
	@Column(name = "idIndice", unique = true, nullable = false, length = 50 )
	@Length(max = 50)
	public String getIdIndice() {
		return idIndice;
	}

	public void setIdIndice(String idIndice) {
		this.idIndice = idIndice;
	}
	
	@OneToMany(mappedBy="indice", fetch = FetchType.LAZY )
	public Set<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(Set<Tipo> tipos) {
		this.tipos = tipos;
	}
	
}
