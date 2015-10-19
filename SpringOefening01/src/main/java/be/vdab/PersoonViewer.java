package be.vdab;

import java.util.List;

public class PersoonViewer {
	
	private boolean aantalKinderenTonen;
	
	public PersoonViewer(boolean aantalKinderenTonen) {
		this.aantalKinderenTonen = aantalKinderenTonen;
	}
	
	public void setAantalKinderenTonen(boolean aantalKinderenTonen) {
		this.aantalKinderenTonen = aantalKinderenTonen;
	}

	public void afbeelden(List<Persoon> personen){
		for(Persoon persoon:personen){
			System.out.println("Nr: "+persoon.getPersoonNr());
			System.out.println("Voornaam: "+persoon.getVoornaam());
			System.out.println("Familienaam: "+persoon.getFamilienaam());
			if (aantalKinderenTonen) System.out.println("Aantal Kinderen: "+persoon.getAantalKinderen());
		}
	}
	
}
