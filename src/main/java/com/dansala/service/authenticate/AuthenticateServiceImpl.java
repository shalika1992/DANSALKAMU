package com.dansala.service.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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
	
	

}
