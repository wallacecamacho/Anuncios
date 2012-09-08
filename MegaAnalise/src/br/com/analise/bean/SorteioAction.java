package br.com.analise.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.solder.logging.Logger;

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



	public String carregar() throws Exception{

		BufferedReader br = new BufferedReader( new InputStreamReader(fileUploadController.getFileUploaded()));
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

		List<Object[]> teste = this.buscaTiposAnuncio();
		
		for(Object[] ob: teste){
			
			NumeroSorteado numeroSorteado = new NumeroSorteado();
			numeroSorteado.setIdNumeroSorteado(new Integer((Integer) ob[0]));
			numeroSorteado.setNumeroSorteado(new Integer((Integer) ob[1]));
			numeroSorteado.setSorteio( new Sorteio((new Integer((Integer) ob[0]))));
			
			this.insertNumeroSoteiado(numeroSorteado);
			
		}
		
		logger.info("  " + teste.size());
		
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


}
