package br.com.analise.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="numeroSorteado" )
public class NumeroSorteado {

	@Id
	@Column(name="idNumeroSorteado", nullable=false, unique=false)
	private Integer idNumeroSorteado;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="numeroSorteado")
	private List<Sorteio> sorteios = new ArrayList<Sorteio>(0);
	
	public Integer getIdNumeroSorteado() {
		return idNumeroSorteado;
	}

	public void setIdNumeroSorteado(Integer idNumeroSorteado) {
		this.idNumeroSorteado = idNumeroSorteado;
	}

	public List<Sorteio> getSorteios() {
		return sorteios;
	}

	public void setSorteios(List<Sorteio> sorteios) {
		this.sorteios = sorteios;
	}
	
	
	
}
