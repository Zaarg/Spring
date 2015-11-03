package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
@XmlRootElement
public class Brouwer implements Serializable {
	private static final long serialVersionUID=1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long brouwerNr;
	
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String naam;
	
	@NotNull
	private Integer omzet;
	
	@Valid
	@Embedded
	private Adres adres;
	
	public Brouwer() {}
	
	public Brouwer(String naam, Integer omzet, Adres adres) {
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}
	
	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		this(naam,omzet,adres);
		this.brouwerNr = brouwerNr;
	}
	
	public long getBrouwerNr() {
		return brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	} 
  		
} 