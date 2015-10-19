package be.vdab;

public class Persoon {
	private int persoonNr;
	private String voornaam;
	private String familienaam;
	private int aantalKinderen;
	
	public Persoon(int persoonNr, String voornaam, String familienaam, int aantalKinderen) {
		setPersoonNr(persoonNr);
		setVoornaam(voornaam);
		setFamilienaam(familienaam);
		setAantalKinderen(aantalKinderen);
	}
	
	public int getPersoonNr() {
		return persoonNr;
	}
	
	public String getVoornaam() {
		return voornaam;
	}
	
	public String getFamilienaam() {
		return familienaam;
	}
	
	public int getAantalKinderen() {
		return aantalKinderen;
	}
	
	public void setPersoonNr(int persoonNr) {
		this.persoonNr = persoonNr;
	}
	
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	
	public void setAantalKinderen(int aantalKinderen) {
		this.aantalKinderen = aantalKinderen;
	}
			
}
