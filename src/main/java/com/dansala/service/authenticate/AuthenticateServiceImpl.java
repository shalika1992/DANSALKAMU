package com.dansala.service.authenticate;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.dao.authenticate.AuthenticateDAOImpl;
import com.dansala.util.common.Common;
import com.dansala.util.common.PasswordDigest;
import com.dansala.util.varlist.CommonVarList;
import com.dansala.util.varlist.MessageVarList;

@Repository
@Scope("prototype")
public class AuthenticateServiceImpl {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	AuthenticateDAOImpl authenticateDAO;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CommonVarList commonVarList;
	
	@Autowired
	Common common;
	
	/**
	 * checkUserExists()
	 * 
	 * @param loginBean
	 * @return String
	 */
	public UserBean checkUserExists(LoginBean loginBean,Locale locale) {
		UserBean userBean=null;
		String message = "";
		String errorcode = commonVarList.ERRORCODE_FAIL_CODE;
		
		try {
			userBean = authenticateDAO.checkUserExists(loginBean);
			if(userBean == null){
				message = messageSource.getMessage(MessageVarList.LOGIN_USER_DOESNOT_EXIT, null, locale);
			}else{
				if(PasswordDigest.encodeToBase64(loginBean.getPassword()).equals(userBean.getPassword())){
					errorcode = commonVarList.ERRORCODE_SUCCESS_CODE;
					
					
					//check first login
					//check reset login
					//check active or de-active user
					//check block user
					//check idle time period of user
				}else{
					message = messageSource.getMessage(MessageVarList.LOGIN_INVALID_CREDENTIALS, null, locale);
				}
			}
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}
		userBean.setErrorCode(errorcode);
		userBean.setMessage(message);
		return userBean;
	}
}
