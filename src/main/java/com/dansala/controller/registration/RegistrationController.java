package com.dansala.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dansala.bean.user.UserBean;
import com.dansala.service.authenticate.AuthenticateServiceImpl;

@Controller
public class RegistrationController {

	
	@Autowired
	AuthenticateServiceImpl authenticateService;
	

	@RequestMapping(value="/loadRegistrationPage", method=RequestMethod.GET)
	public ModelAndView loadRegisterPage(){		
		return new ModelAndView("register", "command", new UserBean());
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("UserBean")UserBean userBean,ModelMap modelMap){		
		userBean=authenticateService.registerUser(userBean);
		if(userBean!=null){
			return new ModelAndView("home");
			
		}
		else{
			return new ModelAndView("register");
		
		}
}
	
}
