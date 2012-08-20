package br.com.anuncios.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;

import org.jboss.solder.logging.Logger;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.anuncios.bean.query.TemplateQuery;
import br.com.anuncios.dao.DAOFactory;
import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.model.Anuncio;
import br.com.anuncios.model.Bairro;
import br.com.anuncios.model.Cidade;
import br.com.anuncios.model.Tipo;
import br.com.anuncios.model.Uf;
import br.com.anuncios.util.ValidatorUtil;

@Named("cadastroAnuncio")
@Stateful
@SessionScoped
public class CadastroAnuncioBean implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2232574716633134714L;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Inject
	private Anuncio anuncio;
	
	@Inject
	@AnuncioRepository
	private EntityManager em;
	
    @Inject
    private BuscaLocalidades buscaLocalidades;
    
    @Inject
    TemplateQuery templateQuery;
	
    @Inject
    private Tipo tipoAnuncio;
	
	private LatLng latlng;
	private MapModel simpleModel; 
	
	private boolean skip;
	
	
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
	
	public MapModel getSimpleModel() {
		return simpleModel;
	}


	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}
		

	public Anuncio getAnuncio() {
		return anuncio;
	}


	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}


	public BuscaLocalidades getBuscaLocalidades() {
		return buscaLocalidades;
	}


	public void setBuscaLocalidades(BuscaLocalidades buscaLocalidades) {
		this.buscaLocalidades = buscaLocalidades;
	}
	

	public Tipo getTipoAnuncio() {
		return tipoAnuncio;
	}


	public void setTipoAnuncio(Tipo tipoAnuncio) {
		this.tipoAnuncio = tipoAnuncio;
	}


	public List<Tipo> buscaTiposAnuncio(){
		return templateQuery.getAllTipos();
	}
	
	
	
	public boolean isSkip() {
		return skip;
	}


	public void setSkip(boolean skip) {
		this.skip = skip;
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

	public void onPointSelect(PointSelectEvent event) {
		
		
		latlng = event.getLatLng();
		this.anuncio.setLat(latlng.getLat());
		this.anuncio.setLgt(latlng.getLng());
		
		simpleModel = new DefaultMapModel();
		simpleModel.addOverlay(new Marker(latlng, "teste"));
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Ponto Selecionado", "Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng()));
		logger.debug("CadastroAnuncioBean - onPointSelect:" + "Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng());

	}
	
	public void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);		
	}
	
	
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    } 
	
	public String cadastraAnuncio() throws Exception{
			
		logger.info("CadastroAnuncioBean - cadastraAnuncio " + "registrando anuncio"); 
		
		String retorno = "";

		anuncio.setDataInclusao(new Date());
		anuncio.setDataAtualizacao(new Date());
		
		anuncio.setDestaque(false);
		anuncio.setAtivo(true);
		
		anuncio.setUsuario("MASTER");
		
		
		anuncio.setUf(buscaLocalidades.getUfVal());
		anuncio.setCidade(buscaLocalidades.getCidadeVal());
		anuncio.setBairro(new Bairro(buscaLocalidades.getBairroVal()));
		
		anuncio.setTipo(tipoAnuncio);
		
		Set<ConstraintViolation<Anuncio>> constraintViolations = ValidatorUtil.getValidator().validate(anuncio);		
		
		logger.info(constraintViolations.size());
		//logger.info(constraintViolations.iterator().next().getMessage());
		
		//addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ramo da Empresa ",constraintViolations.iterator().next().getMessage()));
		
		if (constraintViolations.size() == 0) {
		
			DAOFactory.DEFAULT.buildAnuncioDAO(em).save(anuncio);
			retorno = "mensagem?faces-redirect=true";
			
		}
		
		return retorno;
	}

	
}
