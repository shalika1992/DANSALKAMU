package com.dansala.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.user.UserBean;
import com.dansala.dao.registration.RegistrationDAOImpl;

@Repository
@Scope("prototype")
public class RegistrationServiceImpl {
	@Autowired
	RegistrationDAOImpl registrationDAO;
	
	public UserBean registerUser(UserBean userBean){
		return 	registrationDAO.registerUser(userBean);
	}
}
