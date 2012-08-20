package br.com.anuncios.handler;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.anuncios.data.AnuncioRepository;
import br.com.anuncios.handler.services.Query;


public class QueryHandler {

	@Inject
	@AnuncioRepository
	EntityManager em;

    @AroundInvoke
    public Object handle(InvocationContext ctx) {

       return em.createQuery(ctx.getMethod().getAnnotation(Query.class).value()).getResultList();

    }
    
}
