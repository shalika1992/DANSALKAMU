package com.dansala.controller.login;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
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
import com.dansala.bean.user.UserBean;
import com.dansala.service.authenticate.AuthenticateServiceImpl;
import com.dansala.service.common.CommonServiceImpl;
import com.dansala.util.common.Common;
import com.dansala.util.validator.LoginBeanValidator;
import com.dansala.util.varlist.CommonVarList;
import com.dansala.util.varlist.MessageVarList;


@Controller
public class LoginController {
	@Autowired
	SessionBean sessionBean;
	
	@Autowired
	AuthenticateServiceImpl authenticateService;
	
	@Autowired
	CommonServiceImpl commonServiceImpl;
	
	@Autowired
	LoginBeanValidator  loginBeanValidator;
	
	@Autowired
	Common common;
	
	@Autowired
	CommonVarList commonVarList;
	

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
	public ModelAndView postLoginPage(@ModelAttribute("LoginBean") @Valid LoginBean loginBean ,BindingResult bindingResult,ModelMap modelMap,HttpServletRequest request,Locale locale){
		ModelAndView modelAndView;
		boolean isUpdateLastLogin = false;
		try{
			if (bindingResult.hasErrors()){
				modelAndView = new ModelAndView("login", "command", new LoginBean());
				modelMap.put("errorMessage",MessageVarList.LOGIN_INVALID_CREDENTIALS);
			}else{
				UserBean userBean=authenticateService.checkUserExists(loginBean,locale);
				if(userBean.getErrorCode().equals(commonVarList.ERRORCODE_SUCCESS_CODE)){
					if(Integer.parseInt(commonVarList.USER_FIRSTLOGIN_ENABLE)== userBean.getFirstLogin()){
						modelAndView = new ModelAndView("verifycode");
						
					}else if(Integer.parseInt(commonVarList.USER_RESET_ENABLE)== userBean.getResetLogin() || commonVarList.STATUS_DEFAULT_DEACTIVE.equals(userBean.getStatusCode())){
						modelAndView = new ModelAndView("changepassword");
						isUpdateLastLogin=true;
						
					}else if(commonVarList.STATUS_DEFAULT_BLOCK.equals(userBean.getStatusCode())){
						modelAndView = new ModelAndView("login", "command", new LoginBean());
						modelMap.put("errorMessage",MessageVarList.LOGIN_USER_BLOCKED);
						isUpdateLastLogin=true;
						
					}else if(commonVarList.STATUS_DEFAULT_ACTIVE.equals(userBean.getStatusCode())){
						String currentDate = commonServiceImpl.getCurrentDate();
						String inactiveTimePeriod=commonServiceImpl.getPwdParamValue(commonVarList.USERPARAM_INACTIVE_PARAMCODE);
						
						boolean isIdleUser = common.checkIdledUser(currentDate, userBean.getLastLoggedDate(), inactiveTimePeriod);
						if(isIdleUser){
							modelAndView = new ModelAndView("changepassword");
						}else{
							/*set sessionId to SessionBean*/
							sessionBean.setSessionId(request.getSession().getId());
							/*set userid to SesionBean*/
							sessionBean.setUserId(userBean.getUserId()+"");
							/*set userbean to sessionBean*/
							sessionBean.setUserBean(userBean);
							
							modelAndView = new ModelAndView("redirect:home.html");
							isUpdateLastLogin=true;
						}
					}else{
						modelAndView = new ModelAndView("login", "command", new LoginBean());
						modelMap.put("errorMessage",MessageVarList.LOGIN_INVALID_CREDENTIALS);
					}
				}else if(userBean.getErrorCode().equals(commonVarList.ERRORCODE_FAIL_CODE)){
					modelAndView = new ModelAndView("login", "command", new LoginBean());
					modelMap.put("errorMessage",userBean.getMessage());
				}else {
					modelAndView = new ModelAndView("login", "command", new LoginBean());
					modelMap.put("errorMessage",MessageVarList.LOGIN_INVALID_CREDENTIALS);
				}
			}
			
			if(isUpdateLastLogin){
				authenticateService.updateLoggedUser(loginBean);
			}
		}catch(Exception e){
			modelAndView= new ModelAndView("login", "command", new LoginBean());
			modelMap.put("errorMessage",MessageVarList.COMMON_ERROR_REQUEST_PROCCESSING);
		}
		return modelAndView;
	}
}
