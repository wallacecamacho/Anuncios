package br.com.anuncios.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.solder.logging.Logger;

import br.com.anuncios.dao.DAOFactory;
import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.model.Bairro;
import br.com.anuncios.model.Cidade;
import br.com.anuncios.model.Uf;

@Named(value="buscaLoc")
@SessionScoped
public class BuscaLocalidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7449824196871864270L;

	private Logger logger = Logger.getLogger(this.getClass());	
		
	@Inject
	@AnuncioRepository
	private EntityManager em;

	private String ufVal;
	private Integer cidadeVal;
	private Integer bairroVal;
	
	private List<Uf> ufs = new ArrayList<Uf>();
	private List<Cidade> cidades = new ArrayList<Cidade>();
	private List<Bairro> bairros = new ArrayList<Bairro>();

	@PostConstruct
	public void buscaUf() throws Exception{

		logger.info("entrando no método buscaUf");
		
		ufs = DAOFactory.DEFAULT.buildUfDAO(em).buscaUf();		
		
		

	}

	public List<Cidade> buscaCidades() {

		logger.info("entrando no método buscaCidades");
		
		Uf uf = new Uf(ufVal);
		
		cidades = DAOFactory.DEFAULT.buildCidadeDAO(em).buscaCidadesByUf(uf);
		

		return cidades; 
	
	}
	
	public void buscaBairros() {

		logger.info("entrando no método buscaBairros");
		
		bairros = DAOFactory.DEFAULT.buildBairroDAO(em).buscaBairrosByCidade(cidadeVal);
		
	}


	public String getUfVal() {
		return ufVal;
	}

	public void setUfVal(String ufVal) {
		this.ufVal = ufVal;
	}

	public Integer getCidadeVal() {
		return cidadeVal;
	}

	public void setCidadeVal(Integer cidadeVal) {
		this.cidadeVal = cidadeVal;
	}

	public Integer getBairroVal() {
		return bairroVal;
	}

	public void setBairroVal(Integer bairroVal) {
		this.bairroVal = bairroVal;
	}

	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	
	
	
}
