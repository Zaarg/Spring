package be.vdab;

import java.util.regex.Pattern;

public class EMailAdres {
  
	private final static Pattern REG_EXPR = Pattern.compile("^.+@.+\\.[a-z]+$"); 
  private final String adres;
  
  public EMailAdres(String adres) { 
    if ( ! REG_EXPR.matcher(adres).matches()) { 
      throw new IllegalArgumentException("Verkeerd emailadres");
    }
    this.adres = adres;
  } 
  
  @Override
  public String toString() {
    return adres;
  }
} 