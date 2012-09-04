package br.com.analise.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.Sorteio;
import br.com.analise.ui.primefaces.FileUploadController;


@Named("sorteioAction")
@Model
public class SorteioAction {

	@Inject
	@AnaliseRepository
	private EntityManager em;

	@Inject
	private Sorteio sorteio;

	@Inject
	private FileUploadController fileUploadController;

	
	public String carregar() throws IOException{

		BufferedReader br = new BufferedReader( new InputStreamReader(fileUploadController.getFileUploaded()));
		boolean stillReading = true;
		
		while( stillReading ){
			
			String[] regs = null;
			Sorteio sorteio = new Sorteio();
			
			if ( br.readLine()!=null ) {
				regs = br.readLine().split(";");
				
				SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
				
				
				sorteio.setIdSorteio(new Integer(regs[0]));
				sorteio.setDezena1(new Integer(regs[1]));
				sorteio.setDezena2(new Integer(regs[2]));
				sorteio.setDezena3(new Integer(regs[3]));
				sorteio.setDezena4(new Integer(regs[4]));
				sorteio.setDezena5(new Integer(regs[5]));
				sorteio.setDezena5(new Integer(regs[6]));
				sorteio.setDezena6(new Integer(regs[7]));				
				sorteio.setDataSorteio(dFormat.parse(regs[8]));
				sorteio.setArrecadacaoTotal(new BigDecimal(regs[9]));
				sorteio.setGanhadoresSena(new Integer(regs[10]));
				sorteio.setRateioSena(new BigDecimal(regs[11]));
				sorteio.setGanhadoresQuina(new Integer(regs[12]));
				sorteio.setRateioQuina(new BigDecimal(regs[13]));
				sorteio.setGanhadoresQuadra(new Integer(regs[14]));
				sorteio.setRateioQuadra(new BigDecimal(regs[15]));
				sorteio.setAcumulado(new BigDecimal(regs[16]));
				sorteio.setValorAcumulado(new BigDecimal(regs[17]));
				sorteio.setEstimativaPrêmio(new BigDecimal(regs[18]));
				sorteio.setAcumuladoMegadaVirada(new BigDecimal(regs[19]));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				insert(sorteio);
				
			}else {
				stillReading = false;
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
