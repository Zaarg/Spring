package be.vdab;

import java.util.List;

public class PersoonViewer {
		
	public void afbeelden(List<Persoon> personen){
		for(Persoon persoon:personen){
			System.out.println("Nr: "+persoon.getPersoonNr());
			System.out.println("Voornaam: "+persoon.getVoornaam());
			System.out.println("Familienaam: "+persoon.getFamilienaam());
			System.out.println("Aantal Kinderen: "+persoon.getAantalKinderen());
		}
	}
}
