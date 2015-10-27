package be.vdab.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;


@Controller 
@RequestMapping("/brouwers")
class BrouwerController { 
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String ALFABET_VIEW = "brouwers/opalfabet";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen"; 
	private final BrouwerService brouwerService;
	
	@Autowired 
	BrouwerController(BrouwerService brouwerService) {  // Spring injecteert de parameter filiaalService met de bean die de interface
		this.brouwerService = brouwerService;			// FiliaalService implementeert: FiliaalServiceImpl
	}
		
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	} 
  
	@RequestMapping(path = "opalfabet", method = RequestMethod.GET)
	String findLetter() {
		return ALFABET_VIEW;
	}
	
	@RequestMapping(path = "opalfabet/{letter}", method = RequestMethod.GET)  
	ModelAndView findNaam(@PathVariable String letter) {   
		ModelAndView modelAndView = new ModelAndView(ALFABET_VIEW);
		List<Brouwer> brouwers = new ArrayList<>(brouwerService.findByNaam(letter));
		if (!brouwers.isEmpty()) {
			modelAndView.addObject("brouwers",brouwers);   
		}
		return modelAndView;
	}
		
	@RequestMapping(path = "beginnaam", method = RequestMethod.GET) 
	ModelAndView findByBeginNaam() {   
		BeginNaam beginNaam = new BeginNaam();
		return new ModelAndView(BEGINNAAM_VIEW).addObject(beginNaam); 
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"beginNaam"})
	ModelAndView findByPostcodeReeks(@Valid BeginNaam beginNaam, BindingResult bindingResult) {
	  ModelAndView modelAndView = new ModelAndView(BEGINNAAM_VIEW);
	  if ( ! bindingResult.hasErrors()) {
		  List<Brouwer> brouwers = brouwerService.findByNaam(beginNaam.getBeginNaam());
		  if (brouwers.isEmpty()) {
		    bindingResult.reject("geenBrouwers"); 
		  } 
		  else {
		    modelAndView.addObject("brouwers", brouwers);
		  }
		}
		return modelAndView;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm() {
		return TOEVOEGEN_VIEW;
	}
	
} 