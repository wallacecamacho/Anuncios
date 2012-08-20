package br.com.anuncios.faces;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class PrimeDataModel<T> extends ListDataModel implements SelectableDataModel<T>, Serializable {

	
	
	public PrimeDataModel() {
		super();

	}

	public PrimeDataModel(List list) {
		super(list);

	}

	@Override
	public T getRowData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getRowKey(T arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
