package be.vdab.gaming;

import org.springframework.beans.factory.annotation.Value;

public class Spelletje { 
  
	private int aantalVijanden;

	public int getAantalVijanden() {
		return aantalVijanden;
	}

	@Value("#{${minimumAantalVijanden} + new java.util.Random().nextInt(2)}")
	public void setAantalVijanden(int aantalVijanden) {
		this.aantalVijanden = aantalVijanden;
	}
		
} 