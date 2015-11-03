package be.vdab.restservices;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import be.vdab.entities.Brouwer;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class BrouwerIdNaam { 
	
	@XmlAttribute   
	private long id;
  
	@XmlAttribute
	private String naam; 
  
	BrouwerIdNaam() {} // JAXB heeft een default constructor nodig
  
	BrouwerIdNaam(Brouwer brouwer) { 
		this.id = brouwer.getBrouwerNr();
		this.naam = brouwer.getNaam();
	}
	
} 