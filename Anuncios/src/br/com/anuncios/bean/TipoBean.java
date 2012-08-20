package br.com.anuncios.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.primefaces.component.tabview.Tab;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.TreeNode;

import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.faces.TipoDataModel;
import br.com.anuncios.model.Anuncio;
import br.com.anuncios.model.Indice;
import br.com.anuncios.model.Tipo;

@Named("tipoBean")
@RequestScoped
public class TipoBean {

	
	@Inject
	@AnuncioRepository
	private EntityManager em;
	private List<Tipo> tipos;
	private Tipo selectedTipo;
	private TipoDataModel tipoDataModel;
	private List<Anuncio> anuncios;
	private String indiceVal;
	
	private TreeNode selectedNode; 





	public void onTipoListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Tipo Tipo)
	{
		retrieveAllTiposOrderedByName();
	}

//	@PostConstruct
	public void retrieveAllTiposOrderedByName()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tipo> criteria = cb.createQuery(Tipo.class);
		Root<Tipo> Tipo = criteria.from(Tipo.class);
		// Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0
		// criteria.select(Tipo).orderBy(cb.asc(Tipo.get(Tipo_.name)));
		criteria.select(Tipo).orderBy(cb.asc(Tipo.get("desctTipo")));
		tipos = em.createQuery(criteria).getResultList();
		
		tipoDataModel = new TipoDataModel(tipos);
		
	}
	

	public List<Tipo> getRetrieveAllTiposOrdered()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tipo> criteria = cb.createQuery(Tipo.class);
		Root<Tipo> Tipo = criteria.from(Tipo.class);
		// Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0
		// criteria.select(Tipo).orderBy(cb.asc(Tipo.get(Tipo_.name)));
		criteria.select(Tipo).orderBy(cb.asc(Tipo.get("desctTipo")));
				
		return tipos = em.createQuery(criteria).getResultList();
	}
	
//    public List<Anuncio> getRetrieveAllAnunciosOrderedDate2(Indice indice){
//        
//    	Query query = em.createQuery("select t from Tipo t where t.indice=:pIndice");
//		query.setParameter("pIndice", indice);
//		
//        return anuncios =  query.getResultList();        
//        
//    }
    
    public void listaTipo() throws Exception{
        
    	Query query = em.createQuery("select t from Tipo t where t.indice.idIndice=:pIndice");
		query.setParameter("pIndice", indiceVal);
		
		tipos =  query.getResultList();        
        
    }
    
    public TipoDataModel retrieveAllTipos(Indice indice){
        
    	Query query = em.createQuery("select t from Tipo t where t.indice=:pIndice");
		query.setParameter("pIndice", indice);
		tipos = query.getResultList();
        return tipoDataModel = new TipoDataModel(tipos);        
        
    }


	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
    
	public String getIndiceVal() {
		return indiceVal;
	}


	public void setIndiceVal(String indiceVal) {
		this.indiceVal = indiceVal;
	}


	public Tipo getSelectedTipo() {
		return selectedTipo;
	}


	public void setSelectedTipo(Tipo selectedTipo) {
		this.selectedTipo = selectedTipo;
	}


	public TipoDataModel getTipoDataModel() {
		return tipoDataModel;
	}

	public void onRowSelect(SelectEvent event) {  
		
		this.selectedTipo = ((Tipo) event.getObject());
		anuncios = selectedTipo.getAnuncios();
		
		for(Anuncio e : anuncios){
			System.out.println(e.getDescricao());
		}
//    	Query query = em.createQuery("select a from Anuncio a where a.tipo = :pTipo ");
//    	query.setParameter("pTipo", selectedTipo.getIdTipo());
//    	anuncios = query.getResultList();
        
		
	}  

	public void onRowUnselect(UnselectEvent event) {  
	  
		this.selectedTipo = ((Tipo) event.getObject()); 
	}
	
	public void onChange(TabChangeEvent event) {
		Tab newTab = event.getTab();
		
		}


	public List<Anuncio> getAnuncios() {
		return anuncios;
	}  
	
    public TreeNode getSelectedNode() {  
        return selectedNode;  
    }  
  
    public void setSelectedNode(TreeNode selectedNode) {  
        this.selectedNode = selectedNode;  
    }  
  
    public void onNodeExpand(NodeExpandEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expanded", event.getTreeNode().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
  
    public void onNodeCollapse(NodeCollapseEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Collapsed", event.getTreeNode().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
  
    public void onNodeSelect(NodeSelectEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
  
    public void onNodeUnselect(NodeUnselectEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unselected", event.getTreeNode().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
	
	
}
