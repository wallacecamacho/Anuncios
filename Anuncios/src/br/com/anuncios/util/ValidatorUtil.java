package br.com.anuncios.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtil {

	private ValidatorUtil(){}
	
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static Validator getValidator(){
		return factory.getValidator();
	}
	
}
