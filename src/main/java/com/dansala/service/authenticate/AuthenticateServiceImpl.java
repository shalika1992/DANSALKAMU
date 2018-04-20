package com.dansala.service.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.dao.authenticate.AuthenticateDAOImpl;
@Repository
@Scope("prototype")
public class AuthenticateServiceImpl {
	
	@Autowired
	AuthenticateDAOImpl authenticateDAO;
	
	public UserBean registerUser(UserBean userBean ){
		return 	authenticateDAO.registerUser(userBean);
	}
	
	public UserBean authenticateUser(LoginBean loginBean){			
		loginBean.setUserName(loginBean.getUserName().trim());
		loginBean.setPassword(loginBean.getPassword().trim());
		if(loginBean.getUserName().indexOf("'")>=0 || loginBean.getUserName().indexOf('"')>=0 ){
			return null;
		}
		else{
			return authenticateDAO.authenticateUser(loginBean);
		}
	}
	

}
