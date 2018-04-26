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
import com.dansala.bean.session.SessionBean;
import com.dansala.service.authenticate.AuthenticateServiceImpl;
import com.dansala.util.validator.LoginBeanValidator;
import com.dansala.util.varlist.MessageVarList;


@Controller
public class LoginController {
	@Autowired
	SessionBean sessionBean;
	
	@Autowired
	AuthenticateServiceImpl authenticateService;
	
	@Autowired
	LoginBeanValidator  loginBeanValidator;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(loginBeanValidator);
	}
	
	/**
	 * getWelcomePage()
	 * @return ModelAndView
	 */
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView getWelcomePage() {
		return new ModelAndView("welcome");
	}
	
	/**
	 * getLoginPage()
	 * @return ModelAndView
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLoginPage() {
		return new ModelAndView("login", "command", new LoginBean());
	}
	
	/**
	 * postLoginPage()
	 * @param  loginBean
	 * @param  bindingResult
	 * @param  modelMap
	 * @param  locale
	 * @return ModelAndView
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView postLoginPage(@ModelAttribute("LoginBean") @Valid LoginBean loginBean ,BindingResult bindingResult,ModelMap modelMap,Locale locale){
		ModelAndView modelAndView;
		try{
			if (bindingResult.hasErrors()){
				modelAndView = new ModelAndView("login", "command", new LoginBean());
				modelMap.put("errorMessage",MessageVarList.LOGIN_INVALID_CREDENTIALS);
			}else{
				String message=authenticateService.checkUserExists(loginBean);
				if(message.isEmpty()){
					//TODO -> SET VALUES TO SESSION BEAN IN HERE
					modelAndView = new ModelAndView("redirect:home.html");
				}else{
					modelAndView = new ModelAndView("login", "command", new LoginBean());
					modelMap.put("errorMessage",MessageVarList.LOGIN_INVALID_CREDENTIALS);
				}
			}
		}catch(Exception e){
			modelAndView= new ModelAndView("login", "command", new LoginBean());
			modelMap.put("errorMessage",MessageVarList.COMMON_ERROR_REQUEST_PROCCESSING);
		}
		return modelAndView;
	}
}
