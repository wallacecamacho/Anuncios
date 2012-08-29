package br.com.analise.ui.primefaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

public class FileUploadController {
	

	   public void handleFileUpload(FileUploadEvent event) {  
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	
}
