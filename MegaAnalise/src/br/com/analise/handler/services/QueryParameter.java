package br.com.analise.handler.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})

public @interface QueryParameter {
	
	String value();
	int[] namedParams();
	int[] params();

}
