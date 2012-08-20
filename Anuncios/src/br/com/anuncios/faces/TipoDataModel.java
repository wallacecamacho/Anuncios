package br.com.anuncios.faces;

import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.primefaces.model.SelectableDataModel;

import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.model.Tipo;

public class TipoDataModel extends ListDataModel<Tipo> implements SelectableDataModel<Tipo>{

	@Inject
	@AnuncioRepository
	private EntityManager em;
	private List<Tipo> tipos;
	private Tipo tipo;
	
	public TipoDataModel() {
		super();
	
	}

	public TipoDataModel(List<Tipo> list) {
		super(list);
	
	}

	@Override
	public Tipo getRowData(String arg0) {
		
		return null;
	}

	@Override
	public Object getRowKey(Tipo arg0) {
	
		return null;
	}

	public void retrieveAllTiposOrderedByName()
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tipo> criteria = cb.createQuery(Tipo.class);
		Root<Tipo> Tipo = criteria.from(Tipo.class);
		// Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0
		// criteria.select(Tipo).orderBy(cb.asc(Tipo.get(Tipo_.name)));
		criteria.select(Tipo).orderBy(cb.asc(Tipo.get("desctTipo")));
		tipos = em.createQuery(criteria).getResultList();
	}
	

}
