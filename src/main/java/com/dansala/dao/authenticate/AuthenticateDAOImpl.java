package com.dansala.dao.authenticate;

import java.util.Date;
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
	
	private final String SQL_GETUSER_DETAILS_USERNAME = "SELECT USERID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUMBER, "
						+ "RESETLOGIN,FIRSTLOGIN,PINCOUNT,CHANNEL,VERIFYCODE,STATUSCODE,USERROLECODE,LASTUPDATEDUSER,LASTLOGGEDTIME,LASTUPDATEDTIME,CREATEDTIME "
						+ "FROM USER WHERE USERNAME=?";
	
	/**
	 * checkUserExists()
	 * 
	 * @param  loginBean
	 * @return UserBean
	 */
	public UserBean checkUserExists(LoginBean loginBean) {
		UserBean userBean = null;
		try{
			List<Map<String, Object>> map = jdbcTemplate.queryForList(SQL_GETUSER_DETAILS_USERNAME, new Object[]{loginBean.getUserName()});
			if(!map.isEmpty()){
				for (Map<String, Object> record : map) {
						userBean = new UserBean();
						userBean.setUserId((long) record.get("USERID"));
						userBean.setUserName((String) record.get("USERNAME"));
						userBean.setPassword((String) record.get("PASSWORD"));
						userBean.setFirstName((String) record.get("FIRSTNAME"));
						userBean.setLastName((String) record.get("LASTNAME"));
						userBean.setEmail((String) record.get("EMAIL"));
						userBean.setPhoneNumber((String) record.get("PHONENUMBER"));
						userBean.setResetLogin((int) record.get("RESETLOGIN"));
						userBean.setFirstLogin((int) record.get("FIRSTLOGIN"));
						userBean.setPincount((int) record.get("PINCOUNT"));
						userBean.setChannel((String) record.get("CHANNEL"));
						userBean.setVerifyCode((String) record.get("VERIFYCODE"));
						userBean.setStatusCode((String) record.get("STATUSCODE"));
						userBean.setUserRoleCode((String) record.get("USERROLECODE"));
						userBean.setLastUpdatedUser((String) record.get("LASTUPDATEDUSER"));
						userBean.setLastLoggedDate((Date) record.get("LASTLOGGEDTIME"));
						userBean.setLastUpdatedTime((Date) record.get("LASTUPDATEDTIME"));
						userBean.setCreatedTime((Date) record.get("CREATEDTIME"));
				}
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return userBean;
	}

	public void deActivateUser(LoginBean loginBean) {
		// TODO Auto-generated method stub
		
	}

	public void updatePinCount(LoginBean loginBean) {
		// TODO Auto-generated method stub
		
	}
}
