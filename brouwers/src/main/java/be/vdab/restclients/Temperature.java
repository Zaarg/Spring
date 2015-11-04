package be.vdab.restclients;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
class Temperature { 
  
	@XmlAttribute
	private double value;

	public double getValue() {
		return value;
	}
		
}