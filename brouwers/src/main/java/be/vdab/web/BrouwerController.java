package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.vdab.services.BrouwerService;

@Controller 
@RequestMapping("/brouwers")
class BrouwerController { 
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen"; 
	private final BrouwerService brouwerService;
	
	@Autowired 
	BrouwerController(BrouwerService brouwerService) {  // Spring injecteert de parameter filiaalService met de bean die de interface
		this.brouwerService = brouwerService;			// FiliaalService implementeert: FiliaalServiceImpl
	}
	@RequestMapping(method = RequestMethod.GET)
	String findAll() {
		return BROUWERS_VIEW;
	} 
  
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	String findNaam() {
		return BEGINNAAM_VIEW;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm() {
		return TOEVOEGEN_VIEW;
	}
	
} 