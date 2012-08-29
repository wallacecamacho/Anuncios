package br.com.analise.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.Sorteio;
import br.com.analise.ui.primefaces.FileUploadController;


@Named
@Model
public class SorteioAction {

	@Inject
	@AnaliseRepository
	private EntityManager em;
	
	@Inject
	private Sorteio sorteio;
	
	@Inject
	private FileUploadController fileUploadController;

	public Sorteio getSorteio() {
		return sorteio;
	}

	public void setSorteio(Sorteio sorteio) {
		this.sorteio = sorteio;
	}

	public FileUploadController getFileUploadController() {
		return fileUploadController;
	}

	public void setFileUploadController(FileUploadController fileUploadController) {
		this.fileUploadController = fileUploadController;
	}
	
	
	
}
