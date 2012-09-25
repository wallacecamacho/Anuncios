package br.com.analise.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.solder.logging.Logger;
import org.primefaces.event.FileUploadEvent;

import br.com.analise.bean.query.TemplateNativeQuery;
import br.com.analise.bean.query.TemplateQuery;
import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.NumeroSorteado;
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

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Inject
	@AnaliseRepository
	private EntityManager em;

	@Inject
	private Sorteio sorteio;

	@Inject
	private FileUploadController fileUploadController;

	@Inject
	TemplateQuery templateQuery;
	
	@Inject
	TemplateNativeQuery templateNativeQuery;
	
	private InputStream fileUploaded;

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


	public String carregar(FileUploadEvent event) throws IOException, ParseException {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
        this.fileUploaded =  event.getFile().getInputstream();	

		BufferedReader br = new BufferedReader( new InputStreamReader(fileUploaded));
		//boolean stillReading = true;
		String[] regs = null;
		String val = "";
		Sorteio psorteio = null;
		while ( val != null ) {

			psorteio = new Sorteio();			

			val = br.readLine();				

			if (val!=null){
				regs = val.split(";");


				SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");

				try {


					psorteio.setIdSorteio(new Integer(regs[0]));
					psorteio.setDataSorteio(dFormat.parse(regs[1]));				
					psorteio.setDezena1(new Integer(regs[2]));
					psorteio.setDezena2(new Integer(regs[3]));
					psorteio.setDezena3(new Integer(regs[4]));
					psorteio.setDezena4(new Integer(regs[5]));
					psorteio.setDezena5(new Integer(regs[6]));
					psorteio.setDezena6(new Integer(regs[7]));				
					psorteio.setArrecadacaoTotal(new BigDecimal(regs[8]));
					psorteio.setGanhadoresSena(new Integer(regs[9]));
					psorteio.setRateioSena(new BigDecimal(regs[10]));
					psorteio.setGanhadoresQuina(new Integer(regs[11]));
					psorteio.setRateioQuina(new BigDecimal(regs[12]));
					psorteio.setGanhadoresQuadra(new Integer(regs[13]));
					psorteio.setRateioQuadra(new BigDecimal(regs[14]));
					psorteio.setAcumulado(regs[15]);
					psorteio.setValorAcumulado(new BigDecimal(regs[16]));
					psorteio.setEstimativaPrêmio(new BigDecimal(regs[17]));
					psorteio.setAcumuladoMegadaVirada(new BigDecimal(regs[18]));

				} catch (ParseException e) {
					e.printStackTrace();
					throw e;
				}

				insert(psorteio);

			}	

		}

		List<Sorteio> sorteios = this.buscaSorteios();
		
		for(Sorteio ob: sorteios){
			
			for (int i =0; i <= 5; i++ ){
				
				NumeroSorteado numeroSorteado = new NumeroSorteado();
				if(i==0){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena1()));
				}
				if(i==1){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena2()));
				}
				if(i==2){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena3()));
				}
				if(i==3){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena4()));
				}
				if(i==4){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena5()));
				}
				if(i==5){
					numeroSorteado.setNumeroSorteado(new Integer((Integer) ob.getDezena6()));
				}
				
				numeroSorteado.setSorteio( ob );
				
				this.insertNumeroSoteiado(numeroSorteado);
				
			}

			
		}
		
		logger.info("  " + sorteios.size());
		
		
		return "teste";
	}

	public void insert(Sorteio pSorteio){
		em.persist(pSorteio);
		em.flush();
	}

	public void insertNumeroSoteiado(NumeroSorteado pNumeroSorteiado){
		em.persist(pNumeroSorteiado);
		em.flush();
	}


	public List<Object[]> buscaTiposAnuncio(){
		return templateNativeQuery.getAllSorteios();
	}

	public List<Sorteio> buscaSorteios(){
		return templateQuery.getAllSorteios();
	}

}
