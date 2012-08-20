package br.com.anuncios.bean.query;

import java.io.Serializable;
import java.util.List;

import br.com.anuncios.handler.services.Query;
import br.com.anuncios.handler.services.QueryService;
import br.com.anuncios.model.Tipo;

@QueryService
public interface TemplateQuery extends Serializable{

	
	 @Query("select t from Tipo t")
	   public List<Tipo> getAllTipos();
	
}
