package be.vdab.restclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:restclient.properties")
public class CreateRestClientBeans {
	
	  @Value("${ecbKoersenURL}")   
	  private URL ecbURL;
	  
	  @Value("${yahooKoersenURL}")
	  private URL yahooURL;
	  
	  @Bean
	  @Qualifier("Yahoo")
	  KoersenClient yahooKoersenClient() {
	      return new YahooKoersenClient(yahooURL); 
	  }
	  
	  @Bean
	  @Qualifier("ECB")
	  KoersenClient ECBKoersenClient() {
	      return new ECBKoersenClient(ecbURL); 
	  }
	  
	  /*@Bean   
	  KoersenClient koersenClient() {
	    try (InputStream stream = yahooURL.openStream()) {     
	    	return new YahooKoersenClient(yahooURL);   
	    } catch (IOException ex) {
	    	return new ECBKoersenClient(ecbURL);   
	    }
	  }*/
	
}