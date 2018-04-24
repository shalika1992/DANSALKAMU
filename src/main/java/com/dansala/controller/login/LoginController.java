package com.dansala.controller.login;

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
import com.dansala.util.validator.LoginBeanValidator;
import com.dansala.util.validator.UserBeanValidator;


@Controller
public class LoginController {
	
	@Autowired
	AuthenticateServiceImpl authenticateService;
	
	@Autowired
	LoginBeanValidator  loginBeanValidator;
	
/*	private UserService userService;*/
	
	@InitBinder
	protected void dataBinding(WebDataBinder binder) {
		if(binder.getTarget()!=null && binder.getTarget().getClass().getSimpleName().equals(
				LoginBean.class.getSimpleName())){
			binder.addValidators(loginBeanValidator);
	   }
			
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView getWelcomePage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/loadLogin", method=RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		return new ModelAndView("login", "command", new LoginBean());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("LoginBean") @Valid LoginBean loginBean ,BindingResult bindingResult,ModelMap modelMap,Locale locale){
		
		if (bindingResult.hasErrors()){
			return new ModelAndView("login", "command", new LoginBean());	
		}
		else{
			UserBean userBean=authenticateService.authenticateUser(loginBean);
			if(userBean==null){
				return new ModelAndView("login", "command", new LoginBean());
			}
			else{
				return new ModelAndView("redirect:home.html");
			}
		}
	}


	
}
