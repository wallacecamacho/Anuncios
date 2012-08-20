package br.com.anuncios.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.anuncios.dao.DAOFactory;
import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.model.Anuncio;
import br.com.anuncios.model.Indice;
import br.com.anuncios.model.Tipo;

@Named("indiceBean")
@ApplicationScoped
public class IndiceBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4005666712206145201L;

	@Inject
	@AnuncioRepository
	private EntityManager em;

	private List<Indice> indices;
	private List<Anuncio> anuncios;
	private Anuncio selectedAnuncio;
	

	private TreeNode root; 
	private TreeNode selectedNode; 

	private LatLng latlng;
	private MapModel simpleModel; 


	public List<Indice> getIndices() {
		return indices;
	}
	
	
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}	
	
	
	public Anuncio getSelectedAnuncio() {
		return selectedAnuncio;
	}


	public void setSelectedAnuncio(Anuncio selectedAnuncio) {
		this.selectedAnuncio = selectedAnuncio;
	}
	

	public void onIndiceListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Tipo Tipo)
	{
		retrieveAllIndicesOrderedByName();
	}
	

	@PostConstruct
	public void retrieveAllIndicesOrderedByName()
	{
		indices = DAOFactory.DEFAULT.buildIndiceDAO(em).findAll();
		Set<Tipo> tipos = new HashSet<Tipo>(0);
		
		root = new DefaultTreeNode("Root",null);
		for(Indice i : indices){
			TreeNode nod = new DefaultTreeNode(i.getIdIndice(), root);
			tipos = i.getTipos();
			
			for(Tipo p : tipos){
				TreeNode node00 = new DefaultTreeNode(p.getDesctTipo(), nod);
			}
			
						
		}
		
	}
	


	public TreeNode getRoot() {
		//retrieveAllIndicesOrderedByName();
		return root;
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
    
    public void montaPonto(){
    	
    	latlng = new LatLng(selectedAnuncio.getLat(), selectedAnuncio.getLgt());
    	
		simpleModel = new DefaultMapModel();
		simpleModel.addOverlay(new Marker(latlng, selectedAnuncio.getDescricao()));
    	
    }
  
    public void onNodeSelect(NodeSelectEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, message);  
        
        for(Indice i : indices){
        	if( i.getIdIndice().equals(selectedNode.getParent().getData())){
        		Tipo t = DAOFactory.DEFAULT.buildTipoDAO(em).findByIndiceDesc(i.getIdIndice(), selectedNode.getData().toString());
        		anuncios = t.getAnuncios();
        		return;
        	}
        }
        
        
    }  
    
  
    public void onNodeUnselect(NodeUnselectEvent event) {  
   
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unselected", event.getTreeNode().toString());  
        FacesContext.getCurrentInstance().addMessage(null, message);  
        
    }  
    

    public String perfilAnuncio(){
    	
    	return "anuncio";
    }
    
    public String perfilAnuncioTemp(){
    	
    	return "anuncioPerfil";
    }

    
}
