package br.com.analise.bean;

import java.io.Serializable;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import br.com.analise.algorithm.CombAnalise;

@Named("combinacaoAction")
@RequestScoped
public class CombinacaoAction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7148488303354422526L;

	private Logger LOGGER = Logger.getLogger(CombinacaoAction.class);
	
	@Inject
	private CombAnalise combAnalise;


	@Resource(mappedName="InVmConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(name="queueAnalise", mappedName="/queue/queueAnalise")
	private Queue queue;
	
	public void loadAnaliseComb(){
		LOGGER.log(Level.INFO, "loadAnaliseComb() enviando para a fila");
		

		Connection con = null;
		Session session = null;
		MessageProducer producer = null;
		//Context ic = null;
		
	
		try{
			//	ic = new InitialContext();
			//connectionFactory = (ConnectionFactory)ic.lookup("/ConnectionFactory");
			//queue = (Queue)ic.lookup("/queue/queueAnuncio");
			
			con = connectionFactory.createConnection();
			session  =  con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			ObjectMessage message = session.createObjectMessage();
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("testando...");
			message.setObject(combAnalise);
			producer.send(message);
			
		}catch(Exception e){
			
			LOGGER.log(Level.ERROR, e.getMessage(), e);

		}  finally {

            try {

                if (producer != null) {

                    producer.close();

                }

                if (session != null) {

                    session.close();

                }

                if (con != null) {

                    con.close();

                }

            } catch (JMSException inException) {

                LOGGER.log(Level.ERROR, inException.getMessage(), inException);

            }

        }
		
		

	}
	
//	public void montaEmail(){
//		LOGGER.log(Level.INFO, "montaEmail() montando email");
//
//		emailvo = new EmailVO();
//		
//		try {
//			
//			emailvo.setHostName("smtp.gmail.com");
//			emailvo.setSmtpPort(587);
//			emailvo.setAuthenticator(new DefaultAuthenticator("wallacecamacho", "25014wanivel0@"));
//			emailvo.setTLS(true);
//			emailvo.setFrom("wallcecamacho@gmail.com");
//			emailvo.setSubject("TestMail");
//			emailvo.setMsg(mensagem);
//			emailvo.addTo("wallacecamacho@gmail.com");
//
//		} catch (EmailException e) {
//
//			LOGGER.log(Level.ERROR, e.getMessage(), e);
//		}
//
//		
//	}
	
	@SuppressWarnings("unchecked")
	public void filaBrowser(){
		LOGGER.log(Level.INFO, "filaBrowser()");
		
		try{
			
			InitialContext ic = new InitialContext();
			
			QueueConnectionFactory factory = (QueueConnectionFactory) ic.lookup("InVmConnectionFactory");
			QueueConnection queueConnection = factory.createQueueConnection();
			QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) ic.lookup("/queue/queueAnalise");
			
			QueueBrowser queueBrowser = queueSession.createBrowser(queue);
			
			Enumeration<TextMessage> enumeration = queueBrowser.getEnumeration();
			while( enumeration.hasMoreElements() ) {
				
				TextMessage message = enumeration.nextElement();
				//EmailVO emailVO = (EmailVO) ((ObjectMessage)message).getObject();
				
				LOGGER.log(Level.INFO, "browser " + message.toString());
//				LOGGER.log(Level.INFO, emailVO.getMimeMessage());
//				LOGGER.log(Level.INFO, emailVO.getSubject());
				
			}
						
			queueBrowser.close();
			queueSession.close();
			queueConnection.close();
			
		}catch (Exception e) {

		}
		
	}

}
