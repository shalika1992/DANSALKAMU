package com.dansala.dao.authenticate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dansala.bean.user.UserBean;

@Repository
@Scope("prototype")
public class AuthenticateDAOImpl {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final Log logger = LogFactory.getLog(getClass());
	private final String addUserSQL  ="INSERT INTO USER(USERNAME,PASSWORD,PHONENUMBER) VALUES(?,?,?)";
	
	
	public UserBean registerUser(UserBean userBean){
		Object [] parameters = {userBean.getUserName(),userBean.getPassword(),userBean.getPhoneNumber()};
		try {
			int rows = jdbcTemplate.update(addUserSQL, parameters);

			if (rows == 1) {
				return userBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception  :  " , e);
			throw e;
		}

	}

}
