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
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final Log logger = LogFactory.getLog(getClass());
	private final String ADD_USER_SQL  ="INSERT INTO USER(USERNAME,PASSWORD,PHONENUMBER) VALUES(?,?,?)";
	private final String AUTHENTICATE_USER_BY_USER_NAME="SELECT USERID,USERNAME,PASSWORD,PHONENUMBER FROM USER WHERE USERNAME=?";
	
	
	public UserBean registerUser(UserBean userBean){
		Object [] parameters = {userBean.getUserName(),userBean.getPassword(),userBean.getPhoneNumber()};
		try {
			int rows = jdbcTemplate.update(ADD_USER_SQL, parameters);

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
	
	public UserBean authenticateUser(LoginBean loginBean){
		Object [] parameters = {loginBean.getUserName()};
		try {
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(AUTHENTICATE_USER_BY_USER_NAME, parameters);

			if (resultSet.size()== 1) {
				for(Map<String,Object> record : resultSet){
					/*System.out.println(record);
					System.out.println(record.get("PASSWORD"));
					System.out.println(record.get("userId"));
					System.out.println(record.get("USERNAME"));
					System.out.println(record.get("PASSWORD"));
					System.out.println(record.get("PHONENUMBER"));*/
					
					if(record.get("PASSWORD").equals(loginBean.getPassword())){;
					UserBean userBean=new UserBean();
					userBean.setUserId ((int)record.get("USERID"));
					userBean.setUserName((String)record.get("USERNAME"));
					userBean.setPassword((String)record.get("PASSWORD"));
					userBean.setPhoneNumber((String)record.get("PHONENUMBER"));
					return userBean;
				}		
				}
			}

		} catch (Exception e) {
			logger.error("Exception  :  " , e);
			throw e;
		}
		
		return null;
	}

}
