package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import be.vdab.restclient.KoersenClient;

@Configuration
@ImportResource("classpath:services.xml") //is alternatief voor @ComponentScan voor combo java.config met xml files
public class CreateServiceBeans { 
  
	/*@Autowired   
	@Qualifier("Yahoo")
	private KoersenClient koersenClient; 
  
	@Bean
	EuroService euroService() {
		return new EuroService(koersenClient);
	}*/
  
} 