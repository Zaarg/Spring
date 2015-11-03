package be.vdab.restservices;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import be.vdab.entities.Brouwer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class BrouwersResource extends ResourceSupport { 
	
	@XmlElement(name="brouwer") 
	@JsonProperty("brouwers") 
	private List<BrouwerIdNaam> brouwerIdNaam = new ArrayList<>(); 
 
	BrouwersResource() {} // JAXB heeft een default constructor nodig
  
	BrouwersResource(Iterable<Brouwer> brouwers, EntityLinks entityLinks) { 
		for (Brouwer brouwer : brouwers) {
			this.brouwerIdNaam.add(new BrouwerIdNaam(brouwer)); 
			this.add(entityLinks.linkToSingleResource(Brouwer.class, brouwer.getBrouwerNr()).withRel("Brouwer:" + brouwer.getBrouwerNr())); 
		}
		this.add(entityLinks.linkToCollectionResource(Brouwer.class)); 
	}
	
}  