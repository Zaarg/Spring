package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import be.vdab.DAO.PersoonDAO;

@Configuration
//@ComponentScan
public class CreateServiceBeans { 
  
	@Autowired
	@Qualifier("persoonTXTDAO")
	private PersoonDAO persoonDAO; 
	
	@Bean
	public PersoonService persoonService() {
		return new PersoonServiceImpl(persoonDAO);
	} 
  
} 