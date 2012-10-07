package br.com.analise.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.sql.DataSource;

import br.com.analise.algorithm.CombAnalise;


@MessageDriven(
		   name = "queueAnaliseProcessor",
		   activationConfig = {
		      @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		      @ActivationConfigProperty( propertyName = "destination", propertyValue ="/queue/queueAnalise")
		   }
		)
public class CombAnaliseMDB  implements MessageListener {

	  private Connection connection;
	  private DataSource dataSource;
	
	// used for the transaction rollback
	  @Resource
	  private MessageDrivenContext context;

	  @Resource(name = "java:/jdbc/AnalisemegaDS")
	  public void setDataSource(DataSource dataSource) {
	    this.dataSource = dataSource;
	  }

	  @PostConstruct
	  public void initialize() {
	    try {
	       connection = dataSource.getConnection();
	    } catch (SQLException sqle) {
	         sqle.printStackTrace();
	    }
	  }

	  @PreDestroy
	  public void cleanup() {
	    try {
	      connection.close();
	      connection = null;
	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	    }
	  }

	  public void onMessage(Message message) {
	    try {
	      ObjectMessage objectMessage = (ObjectMessage) message;
	      CombAnalise combAnalise = (CombAnalise) objectMessage.getObject();
	    //  processShippingRequest(combAnalise);
	      System.out.println("Shipping request processed.");
	    } catch (JMSException jmse) {
	        jmse.printStackTrace();
	        context.setRollbackOnly();
	    }// catch (SQLException sqle) {
	   //     sqle.printStackTrace();
	   //     context.setRollbackOnly();
	   // }
	  }
	  
	  // This method would use JPA in the real world to persist the data   
	  private void processShippingRequest(CombAnalise request) throws SQLException {
	    Statement statement = connection.createStatement();
	    String sql = "INSERT INTO " + "SHIPPING_REQUESTS(" + "ITEM, ";
	                
	    System.out.println(sql);
	    statement.execute(sql);
	  }
	
}
