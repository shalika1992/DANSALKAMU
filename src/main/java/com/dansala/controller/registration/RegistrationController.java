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

import com.dansala.bean.register.RegisterUserBean;
import com.dansala.bean.user.UserBean;
import com.dansala.service.registration.RegistrationServiceImpl;
import com.dansala.util.validator.RegisterUserBeanValidator;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationServiceImpl registrationService;

	@Autowired
	RegisterUserBeanValidator userBeanValidator;

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(userBeanValidator);
	}

	@RequestMapping(value = "/loadRegistrationPage", method = RequestMethod.GET)
	public ModelAndView loadRegisterPage() {
		return new ModelAndView("register", "command", new RegisterUserBean());
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("RegisterUserBean") @Valid RegisterUserBean registerUserBean, BindingResult bindingResult,ModelMap modelMap, Locale locale) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register", "command", new UserBean());
		} else {
			registerUserBean = registrationService.registerUser(registerUserBean);
			if (registerUserBean != null) {
				return new ModelAndView("home");
			} else {
				return new ModelAndView("register", "command", new UserBean());
			}
		}
	}

}
