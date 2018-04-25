package com.dansala.dao.registration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dansala.bean.user.UserBean;

@Repository
@Scope("prototype")
public class RegistrationDAOImpl {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String ADD_USER_SQL = "INSERT INTO USER(USERNAME,PASSWORD,PHONENUMBER) VALUES(?,?,?)";
	
	public UserBean registerUser(UserBean userBean) {
		Object[] parameters = { userBean.getUserName(), userBean.getPassword(), userBean.getPhoneNumber() };
		try {
			int rows = jdbcTemplate.update(ADD_USER_SQL, parameters);

			if (rows == 1) {
				return userBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}

	}
}
