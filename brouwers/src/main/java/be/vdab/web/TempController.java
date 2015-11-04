package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.exceptions.KanTemperatuurNietLezenException;
import be.vdab.services.TempService;

@Controller
@RequestMapping("temp")
public class TempController {
	
	private final static String VIEW = "temp/tempingemeente";
	private final TempService tempService;
	
	@Autowired
	TempController(TempService tempService) {
	    this.tempService = tempService;
	}

	@RequestMapping(path = "{gemeente}/tempingemeente", method = RequestMethod.GET)
	ModelAndView tempInGemeente(@PathVariable String gemeente) {
	    ModelAndView modelAndView = new ModelAndView(VIEW);
	    try {
	    	modelAndView.addObject("temp", tempService.geefTemp(gemeente));
	    }
	    catch (KanTemperatuurNietLezenException ex) {
	      modelAndView.addObject("fout", "Kan temperatuur niet lezen");
	    }
	    return modelAndView;
	  }
	
}
