package br.com.analise.data;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.solder.core.ExtensionManaged;

public class AnaliseRepositoryProducer {

	@SuppressWarnings("unused")
	@ExtensionManaged
	@Produces
	@AnaliseRepository
	@PersistenceContext
	
	private EntityManager em;
}
