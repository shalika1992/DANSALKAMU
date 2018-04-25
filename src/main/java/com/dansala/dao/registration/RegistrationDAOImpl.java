package com.dansala.dao.registration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dansala.bean.register.RegisterUserBean;


@Repository
@Scope("prototype")
public class RegistrationDAOImpl {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String ADD_USER_SQL = "INSERT INTO USER(USERNAME,PASSWORD,PHONENUMBER) VALUES(?,?,?)";
	
	public RegisterUserBean registerUser(RegisterUserBean registerUserBean) {
		Object[] parameters = { registerUserBean.getUserName(), registerUserBean.getPassword(), registerUserBean.getPhoneNumber() };
		try {
			int rows = jdbcTemplate.update(ADD_USER_SQL, parameters);

			if (rows == 1) {
				return registerUserBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}

	}
}
