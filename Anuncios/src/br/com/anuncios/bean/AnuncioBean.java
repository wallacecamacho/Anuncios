package br.com.anuncios.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.anuncios.model.Anuncio;

@Named("anuncioBean")
@RequestScoped		
public class AnuncioBean {
	
       @PersistenceContext(unitName="AnuncioApp")
       private EntityManager em;
       private List<Anuncio> anuncios;
       private Anuncio selectedAnuncio;
       

       
    private static final String EJBQL = "select anuncio from Anuncio anuncio";
        
    
    public Anuncio getSelectedAnuncio() {
        return selectedAnuncio;
    }


    public void setSelectedAnuncio(Anuncio selectedAnuncio) {
        this.selectedAnuncio = selectedAnuncio;
    }

    private static final String[] RESTRICTIONS = {
        "lower(anuncio.descricao) like lower(concat(#{anuncioList.anuncio.descricao},'%'))",
        "lower(anuncio.titulo) like lower(concat(#{anuncioList.anuncio.titulo},'%'))",
        "lower(anuncio.email) like lower(concat(#{anuncioList.anuncio.email},'%'))",
        "lower(anuncio.logradouroCompleto) like lower(concat(#{anuncioList.anuncio.logradouroCompleto},'%'))",
        "lower(anuncio.user) like lower(concat(#{anuncioList.anuncio.user},'%'))",
        "lower(anuncio.ufGrupoCodigoUf) like lower(concat(#{anuncioList.anuncio.ufGrupoCodigoUf},'%'))", };

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }


    public List<Anuncio> getretrieveAllAnunciosOrderedDate(){
        
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Anuncio> criteria = cb.createQuery(Anuncio.class);
          Root<Anuncio> member = criteria.from(Anuncio.class);
          // Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0
          // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
          criteria.select(member).orderBy(cb.asc(member.get("dataAnuncio")));
         return anuncios = em.createQuery(criteria).getResultList();
        
    }
    
    public List<Anuncio> getRetrieveAllAnunciosOrderedDate2(){
        
        return anuncios =  em.createQuery(EJBQL).getResultList();
        
    }

}
