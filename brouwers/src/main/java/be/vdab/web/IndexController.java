package be.vdab.web;

import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {

	private static final String VIEW = "index";
	private static final String GROETEN = "groeten";
		
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		switch (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			case 0: case 1: case 2: case 3: case 4: case 5:
				modelAndView.addObject(GROETEN, "goedenacht");
				break;
			case 6: case 7: case 8: case 9: case 10: case 11:
				modelAndView.addObject(GROETEN, "goedemorgen");
				break;
			case 12: case 13: case 14: case 15: case 16: case 17:
				modelAndView.addObject(GROETEN, "goedemiddag");
				break;
			default:
				modelAndView.addObject(GROETEN, "goedeavond");
		}
		return modelAndView;
	}
	
} 