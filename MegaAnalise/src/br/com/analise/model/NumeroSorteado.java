package br.com.analise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="numeroSorteado" )
public class NumeroSorteado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idNumeroSorteado", nullable=false, unique=false)
	private Integer idNumeroSorteado;
	
	@Column(name="numeroSorteado", nullable=false)
	private Integer numeroSorteado;
	
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sorteio", nullable=true)
	private Sorteio sorteio;
	
	public Integer getIdNumeroSorteado() {
		return idNumeroSorteado;
	}

	public void setIdNumeroSorteado(Integer idNumeroSorteado) {
		this.idNumeroSorteado = idNumeroSorteado;
	}
	
	public Sorteio getSorteio() {
		return sorteio;
	}

	public void setSorteio(Sorteio sorteio) {
		this.sorteio = sorteio;
	}

	public Integer getNumeroSorteado() {
		return numeroSorteado;
	}

	public void setNumeroSorteado(Integer numeroSorteado) {
		this.numeroSorteado = numeroSorteado;
	}
	
	
	
}
