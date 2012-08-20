package br.com.anuncios.data;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.solder.core.ExtensionManaged;

public class AnuncioRepositoryProducer {

	@SuppressWarnings("unused")
	@ExtensionManaged
	@Produces
	@AnuncioRepository
	@PersistenceContext
	
	private EntityManager em;
}
