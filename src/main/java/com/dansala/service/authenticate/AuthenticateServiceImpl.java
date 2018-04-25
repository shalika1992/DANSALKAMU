package com.dansala.service.authenticate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.dao.authenticate.AuthenticateDAOImpl;

@Repository
@Scope("prototype")
public class AuthenticateServiceImpl {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	AuthenticateDAOImpl authenticateDAO;

	/**
	 * checkUserExists()
	 * 
	 * @param loginBean
	 * @return String
	 */
	public String checkUserExists(LoginBean loginBean) {
		String message = "";
		try {
			UserBean userBean = authenticateDAO.checkUserExists(loginBean);
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}
		return message;
	}
	
	/**
	 * authenticateUser()
	 * @param  loginBean
	 * @return UserBean
	 */
	public UserBean authenticateUser(LoginBean loginBean) {
		try {
			if (loginBean.getUserName().indexOf("'") >= 0 || loginBean.getUserName().indexOf('"') >= 0) {
				return null;
			} else {
				return authenticateDAO.checkUserExists(loginBean);
			}
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}
	}
}
