package be.vdab.restclient;

import java.math.BigDecimal; 

public class DummyKoersenClient implements KoersenClient {
  
	@Override 
	public BigDecimal getDollarKoers() {
		return BigDecimal.valueOf(1.5);
	}
	
} 