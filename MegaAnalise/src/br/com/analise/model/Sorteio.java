package br.com.analise.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sorteio" )
public class Sorteio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352850586164704602L;

	@Id
	@Column(name="idSorteio", nullable=false, unique=true)
	private Integer idSorteio;
	
	
	@Column(name = "dezena1")
	private Integer dezena1;
	
	@Column(name = "dezena2")
	private Integer dezena2;
	
	@Column(name = "dezena3")
	private Integer dezena3;
	
	@Column(name = "dezena4")
	private Integer dezena4;
	
	@Column(name = "dezena5")
	private Integer dezena5;
	
	@Column(name = "dezena6")
	private Integer dezena6;
	
	@Column(name = "dataSorteio")
	@Temporal(TemporalType.DATE)
	private Date dataSorteio;

	@Column(name = "arrecadacaoTotal")
	private BigDecimal arrecadacaoTotal;
	
	@Column(name = "ganhadoresSena")
	private Integer ganhadoresSena;
	
	@Column(name = "rateioSena")
	private BigDecimal rateioSena;
	
	@Column(name = "ganhadoresQuina")
	private Integer ganhadoresQuina;
	
	@Column(name = "rateioQuina")
	private BigDecimal rateioQuina;
	
	@Column(name = "ganhadoresQuadra")
	private Integer ganhadoresQuadra;
	
	@Column(name = "rateioQuadra")
	private BigDecimal rateioQuadra;
	
	@Column(name = "acumulado")
	private BigDecimal acumulado;
	
	@Column(name = "valorAcumulado")
	private BigDecimal valorAcumulado;
	
	@Column(name = "estimativaPrêmio")
	private BigDecimal estimativaPrêmio;
	
	@Column(name = "acumuladoMegadaVirada")
	private BigDecimal acumuladoMegadaVirada;
	
	
	public Integer getIdSorteio() {
		return idSorteio;
	}

	public void setIdSorteio(Integer idSorteio) {
		this.idSorteio = idSorteio;
	}

	public Integer getDezena1() {
		return dezena1;
	}

	public void setDezena1(Integer dezena1) {
		this.dezena1 = dezena1;
	}

	public Integer getDezena2() {
		return dezena2;
	}

	public void setDezena2(Integer dezena2) {
		this.dezena2 = dezena2;
	}

	public Integer getDezena3() {
		return dezena3;
	}

	public void setDezena3(Integer dezena3) {
		this.dezena3 = dezena3;
	}

	public Integer getDezena4() {
		return dezena4;
	}

	public void setDezena4(Integer dezena4) {
		this.dezena4 = dezena4;
	}

	public Integer getDezena5() {
		return dezena5;
	}

	public void setDezena5(Integer dezena5) {
		this.dezena5 = dezena5;
	}

	public Integer getDezena6() {
		return dezena6;
	}

	public void setDezena6(Integer dezena6) {
		this.dezena6 = dezena6;
	}

	public Date getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(Date dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	public BigDecimal getArrecadacaoTotal() {
		return arrecadacaoTotal;
	}

	public void setArrecadacaoTotal(BigDecimal arrecadacaoTotal) {
		this.arrecadacaoTotal = arrecadacaoTotal;
	}

	public Integer getGanhadoresSena() {
		return ganhadoresSena;
	}

	public void setGanhadoresSena(Integer ganhadoresSena) {
		this.ganhadoresSena = ganhadoresSena;
	}

	public BigDecimal getRateioSena() {
		return rateioSena;
	}

	public void setRateioSena(BigDecimal rateioSena) {
		this.rateioSena = rateioSena;
	}

	public Integer getGanhadoresQuina() {
		return ganhadoresQuina;
	}

	public void setGanhadoresQuina(Integer ganhadoresQuina) {
		this.ganhadoresQuina = ganhadoresQuina;
	}

	public BigDecimal getRateioQuina() {
		return rateioQuina;
	}

	public void setRateioQuina(BigDecimal rateioQuina) {
		this.rateioQuina = rateioQuina;
	}

	public Integer getGanhadoresQuadra() {
		return ganhadoresQuadra;
	}

	public void setGanhadoresQuadra(Integer ganhadoresQuadra) {
		this.ganhadoresQuadra = ganhadoresQuadra;
	}

	public BigDecimal getRateioQuadra() {
		return rateioQuadra;
	}

	public void setRateioQuadra(BigDecimal rateioQuadra) {
		this.rateioQuadra = rateioQuadra;
	}

	public BigDecimal getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(BigDecimal acumulado) {
		this.acumulado = acumulado;
	}

	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public BigDecimal getEstimativaPrêmio() {
		return estimativaPrêmio;
	}

	public void setEstimativaPrêmio(BigDecimal estimativaPrêmio) {
		this.estimativaPrêmio = estimativaPrêmio;
	}

	public BigDecimal getAcumuladoMegadaVirada() {
		return acumuladoMegadaVirada;
	}

	public void setAcumuladoMegadaVirada(BigDecimal acumuladoMegadaVirada) {
		this.acumuladoMegadaVirada = acumuladoMegadaVirada;
	}
	
	
	
	
}
