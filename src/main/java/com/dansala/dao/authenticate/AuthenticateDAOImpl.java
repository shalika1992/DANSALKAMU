package com.dansala.dao.authenticate;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;

@Repository
@Scope("prototype")
public class AuthenticateDAOImpl {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String AUTHENTICATE_USER_BY_USER_NAME = "SELECT USERID,USERNAME,PASSWORD,PHONENUMBER FROM USER WHERE USERNAME=?";
	
	public String checkUserExists(LoginBean loginBean) {
		try{
			
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return "";
	}
	
	public UserBean authenticateUser(LoginBean loginBean) {
		Object[] parameters = { loginBean.getUserName() };
		try {
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(AUTHENTICATE_USER_BY_USER_NAME, parameters);
			if (resultSet.size() == 1) {
				for (Map<String, Object> record : resultSet) {
					if (record.get("PASSWORD").equals(loginBean.getPassword())) {
						UserBean userBean = new UserBean();
						userBean.setUserId((long) record.get("USERID"));
						userBean.setUserName((String) record.get("USERNAME"));
						userBean.setPassword((String) record.get("PASSWORD"));
						userBean.setPhoneNumber((String) record.get("PHONENUMBER"));
						return userBean;
					}
				}
			}
		} catch (Exception e) {
			logger.error("Exception  :  ", e);
			throw e;
		}

		return null;
	}


	

}
