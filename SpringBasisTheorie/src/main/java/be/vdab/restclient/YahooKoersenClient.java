package be.vdab.restclient;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Qualifier("Yahoo")
public class YahooKoersenClient implements KoersenClient {
  
	private final URL url;
  
	@Autowired
	public YahooKoersenClient(@Value("${yahooKoersenURL}") URL url) { 
    this.url = url;
	} 
  
	@Override
	public BigDecimal getDollarKoers() {
		try (Scanner scanner = new Scanner(url.openStream())) {
			return new BigDecimal(scanner.nextLine());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
} 