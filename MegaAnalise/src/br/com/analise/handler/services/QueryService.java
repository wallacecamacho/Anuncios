package br.com.analise.handler.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.solder.serviceHandler.ServiceHandlerType;

import br.com.analise.handler.QueryHandler;

@ServiceHandlerType(QueryHandler.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface QueryService {

}
