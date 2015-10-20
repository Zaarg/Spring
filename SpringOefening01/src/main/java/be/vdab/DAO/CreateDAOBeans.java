package be.vdab.DAO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:DAO.properties")
public class CreateDAOBeans {
	
	  @Value("${personenCSV}")
	  private File persoonCSVFile;
	  
	  @Value("${personenTXT}")
	  private File persoonTXTFile;
	    
	  @Bean
	  @Qualifier("persoonCSVDAO")
	  PersoonDAO persoonDAOCSV() {
	      return new PersoonDAOCSV(persoonCSVFile); 
	  }
	  
	  @Bean
	  @Qualifier("persoonTXTDAO")
	  PersoonDAO persoonDAOMeerdereRegels() {
	      return new PersoonDAOMeerdereRegels(persoonTXTFile); 
	  }
			
}