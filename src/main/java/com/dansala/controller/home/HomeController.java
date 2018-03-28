package com.dansala.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class HomeController {
	
	@RequestMapping(value="/loadDansalaPage", method=RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		return new ModelAndView("dansalaPage");
	}
	@RequestMapping(value="/homePage", method=RequestMethod.GET)
	public ModelAndView loadHome(){	
		return new ModelAndView("home");
		
	}
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public ModelAndView loadMap(){	
		return new ModelAndView("map");
		
	}


}
