package br.com.analise.ui.primefaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

public class FileUploadController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4022114392622437394L;
	private InputStream fileUploaded;
	
		
	public InputStream getFileUploaded() {
		return fileUploaded;
	}

	public void setFileUploaded(InputStream fileUploaded) {
		this.fileUploaded = fileUploaded;
	}



	public void handleFileUpload(FileUploadEvent event) throws IOException {  
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	        
	        this.fileUploaded =  event.getFile().getInputstream();	        
	    }  
	
}
