package be.vdab;

import java.util.List;

import be.vdab.services.PersoonService;

public class PersoonViewer {
	
	private final PersoonService persoonService;
	private final PersoonEigenschap[] eigenschappen;
		
	public PersoonViewer(PersoonService persoonService,PersoonEigenschap[] eigenschappen){
		this.persoonService = persoonService;
		this.eigenschappen=eigenschappen;
	}
	
	public void afbeelden(){
		List<Persoon> personen = persoonService.findAll();
		for(Persoon persoon:personen){
			for (PersoonEigenschap eigenschap : eigenschappen) {
		        toonEigenschap(persoon, eigenschap);
		        System.out.print(' ');
		      }
		      System.out.println();
		}
	}
	
	private void toonEigenschap(Persoon persoon, PersoonEigenschap eigenschap) { 
	    switch (eigenschap) {
	    case PERSOON_NR:
	      System.out.print(persoon.getPersoonNr());
	      break;
	    case VOORNAAM:
	      System.out.print(persoon.getVoornaam());
	      break;
	    case FAMILIENAAM:
	      System.out.print(persoon.getFamilienaam());
	      break;
	    case AANTAL_KINDEREN:
	      System.out.print(persoon.getAantalKinderen());
	      break;
	    }
	  }
	
}
