package be.vdab.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import be.vdab.PersoonEigenschap;
import be.vdab.services.PersoonService;

public class CreatePresentationBeans {

	@Autowired 
	private PersoonService persoonService;
	
	@Bean 
	public PersoonViewer persoonViewer() {
	  return new PersoonViewer(persoonService, new PersoonEigenschap[] {
			  PersoonEigenschap.PERSOON_NR,PersoonEigenschap.VOORNAAM, PersoonEigenschap.FAMILIENAAM,
		      PersoonEigenschap.AANTAL_KINDEREN });
	}
}
