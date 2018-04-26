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
	
	/**
	 * getRegister()
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		return new ModelAndView("register", "command", new RegisterUserBean());
	}
	
	/**
	 * postRegister()
	 * @param  registerUserBean
	 * @param  bindingResult
	 * @param  modelMap
	 * @param  locale
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postRegister(@ModelAttribute("RegisterUserBean") @Valid RegisterUserBean registerUserBean, BindingResult bindingResult,ModelMap modelMap, Locale locale) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register", "command", new RegisterUserBean());
		} else {
			registerUserBean = registrationService.registerUser(registerUserBean);
			if (registerUserBean != null) {
				return new ModelAndView("home");
			} else {
				return new ModelAndView("register", "command", new RegisterUserBean());
			}
		}
	}

}
