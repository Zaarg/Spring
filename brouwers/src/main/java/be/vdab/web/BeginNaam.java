package be.vdab.web;

import org.hibernate.validator.constraints.NotBlank;

class BeginNaam {
	 
	@NotBlank private String beginNaam;
		
	public String getBeginNaam() {
		return beginNaam;
	} 
  	
	public void setBeginNaam(String beginNaam) {
		this.beginNaam = beginNaam;
	}
	
} 