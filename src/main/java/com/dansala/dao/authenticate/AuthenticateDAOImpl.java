package com.dansala.dao.authenticate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.service.common.CommonServiceImpl;
import com.dansala.util.varlist.CommonVarList;

@Repository
@Scope("prototype")
public class AuthenticateDAOImpl {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CommonServiceImpl commonServiceImpl;
	
	@Autowired
	CommonVarList commonVarList;
	
	private final String SQL_GETUSER_WITHUSERNAME = "SELECT USERID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUMBER, "
						+ "RESETLOGIN,FIRSTLOGIN,PINCOUNT,CHANNEL,VERIFYCODE,STATUSCODE,USERROLECODE,LASTUPDATEDUSER,LASTLOGGEDTIME,LASTUPDATEDTIME,CREATEDTIME "
						+ "FROM USER WHERE USERNAME=?";
	
	private final String SQL_UPDATEPINCOUNT_WITHUSERNAME="UPDATE USER SET PINCOUNT=? WHERE USERNAME=?";
	
	private final String SQL_UPDATESTATUSCODE_WITHUSERNAME="UPDATE USER SET STATUSCODE=? WHERE USERNAME=?";
	
	private final String SQL_UPDATEUSER_WITHUSERNAME="UPDATE USER SET PINCOUNT=? ,LASTLOGGEDTIME=? WHERE USERNAME=?";
	
	/**
	 * checkUserExists()
	 * 
	 * @param  loginBean
	 * @return UserBean
	 */
	public UserBean checkUserExists(LoginBean loginBean) {
		UserBean userBean = null;
		try{
			List<Map<String, Object>> map = jdbcTemplate.queryForList(SQL_GETUSER_WITHUSERNAME, new Object[]{loginBean.getUserName()});
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
	
	/**
	 * updatePinCount()
	 * @param  loginBean
	 * @return boolean
	 */
	@Transactional
	public boolean updatePinCount(LoginBean loginBean,int pincount) {
		boolean isUpdateOk = false;
		try{
			int value = jdbcTemplate.update(SQL_UPDATEPINCOUNT_WITHUSERNAME,new Object[] {pincount,loginBean.getUserName()});
			if(value == 1){
				isUpdateOk = true;
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return isUpdateOk;
	}
	
	/**
	 * deActivateUser()
	 * @param  loginBean
	 * @return boolean
	 */
	@Transactional
	public boolean deActivateUser(LoginBean loginBean) {
		boolean isUpdateOk = false;
		try{
			int value = jdbcTemplate.update(SQL_UPDATESTATUSCODE_WITHUSERNAME,new Object[] { commonVarList.STATUS_DEFAULT_DEACTIVE,loginBean.getUserName()});
			if(value == 1){
				isUpdateOk = true;
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return isUpdateOk;
	}
	
	/**
	 * updateLoggedUser()
	 * @param  loginBean
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean updateLoggedUser(LoginBean loginBean) throws Exception {
		boolean isUpdateOk = false;
		DateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			String currentDateString=commonServiceImpl.getCurrentDate();
			Date currentDate = simpleDateFormatter.parse(currentDateString);
			
			System.out.println("currentDate ----------------------:"+currentDate);
			
			int value = jdbcTemplate.update(SQL_UPDATEUSER_WITHUSERNAME,new Object[] { commonVarList.USER_DEFAULT_PINCOUNT,currentDate,loginBean.getUserName()});
			if(value == 1){
				isUpdateOk = true;
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return isUpdateOk;
	}
}
