package com.dansala.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.dansala.bean.register.RegisterUserBean;
import com.dansala.dao.registration.RegistrationDAOImpl;

@Repository
@Scope("prototype")
public class RegistrationServiceImpl {
	@Autowired
	RegistrationDAOImpl registrationDAO;
	
	public RegisterUserBean registerUser(RegisterUserBean registerUserBean){
		return 	registrationDAO.registerUser(registerUserBean);
	}
}
