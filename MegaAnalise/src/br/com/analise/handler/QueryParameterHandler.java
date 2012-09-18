package br.com.analise.handler;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.analise.data.AnaliseRepository;
import br.com.analise.handler.services.QueryParameter;

public class QueryParameterHandler {

	
	@Inject
	@AnaliseRepository
	EntityManager em;

    @AroundInvoke
    public Object handle(InvocationContext ctx) {
    	Query q = em.createNativeQuery(ctx.getMethod().getAnnotation(QueryParameter.class).value());
    	
    	
		if ( ctx.getMethod().getAnnotation(QueryParameter.class).namedParams() != null) {
			
			for (int i = 0; i < ctx.getMethod().getAnnotation(QueryParameter.class).namedParams().length; i++) {
				q.setParameter(ctx.getMethod().getAnnotation(QueryParameter.class).namedParams()[i], ctx.getMethod().getAnnotation(QueryParameter.class).params()[i]);
			}
		}
    	
   
        return q.getResultList();
    }
	
}
