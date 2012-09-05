package br.com.analise.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.FileUploadEvent;

import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.Sorteio;
import br.com.analise.ui.primefaces.FileUploadController;


@Named("sorteioAction")
@SessionScoped
@Stateful
public class SorteioAction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4752146545039016666L;

	@Inject
	@AnaliseRepository
	private EntityManager em;

	@Inject
	private Sorteio sorteio;

	@Inject
	private FileUploadController fileUploadController;

	public String carregar() throws IOException{

		BufferedReader br = new BufferedReader( new InputStreamReader(fileUploadController.getFileUploaded()));
		//boolean stillReading = true;
		String[] regs = null;
		String val = "";
		Sorteio sorteio = null;
		while ( val != null ) {
			
				sorteio = new Sorteio();			
			
				val = br.readLine();				

				if (val!=null){
				regs = val.split(";");
				
				
				SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
				
				
				sorteio.setIdSorteio(new Integer(regs[0]));
				sorteio.setDataSorteio(dFormat.parse(regs[1]));				
				sorteio.setDezena1(new Integer(regs[2]));
				sorteio.setDezena2(new Integer(regs[3]));
				sorteio.setDezena3(new Integer(regs[4]));
				sorteio.setDezena4(new Integer(regs[5]));
				sorteio.setDezena5(new Integer(regs[6]));
				sorteio.setDezena6(new Integer(regs[7]));				
				sorteio.setArrecadacaoTotal(new BigDecimal(regs[8]));
				sorteio.setGanhadoresSena(new Integer(regs[9]));
				sorteio.setRateioSena(new BigDecimal(regs[10]));
				sorteio.setGanhadoresQuina(new Integer(regs[11]));
				sorteio.setRateioQuina(new BigDecimal(regs[12]));
				sorteio.setGanhadoresQuadra(new Integer(regs[13]));
				sorteio.setRateioQuadra(new BigDecimal(regs[14]));
				sorteio.setAcumulado(regs[15]);
				sorteio.setValorAcumulado(new BigDecimal(regs[16]));
				sorteio.setEstimativaPrêmio(new BigDecimal(regs[17]));
				sorteio.setAcumuladoMegadaVirada(new BigDecimal(regs[18]));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				insert(sorteio);
				
			
				}	
			
		}

		return "teste";
	}
	
	public void insert(Sorteio pSorteio){
		em.persist(pSorteio);
	}

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
