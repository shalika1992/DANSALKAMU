package com.dansala.controller.registration;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.service.authenticate.AuthenticateServiceImpl;
import com.dansala.util.validator.UserBeanValidator;

@Controller
public class RegistrationController {

	
	@Autowired
	AuthenticateServiceImpl authenticateService;
	
	@Autowired
	UserBeanValidator userBeanValidator;
	
	@InitBinder
	protected void dataBinding(WebDataBinder binder) {
		if(binder.getTarget()!=null && binder.getTarget().getClass().getSimpleName().equals(
				UserBean.class.getSimpleName())){
			binder.addValidators(userBeanValidator);
	   }
			
	}
	

	@RequestMapping(value="/loadRegistrationPage", method=RequestMethod.GET)
	public ModelAndView loadRegisterPage(){		
		return new ModelAndView("register", "command", new UserBean());
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("UserBean")@Valid UserBean userBean,BindingResult bindingResult,ModelMap modelMap,Locale locale){		
		if (bindingResult.hasErrors()){
			return new ModelAndView("register", "command", new UserBean());	
		}
		else{
			userBean=authenticateService.registerUser(userBean);
			if(userBean!=null){
				return new ModelAndView("home");
				
			}
			else{
				return new ModelAndView("register", "command", new UserBean());
			
			}
		}
}
	
}
