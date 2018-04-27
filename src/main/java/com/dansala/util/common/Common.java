package com.dansala.util.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Common {
	/**
	 * checkNullAndEmpty()
	 * @param  value
	 * @return boolean
	 */
	public boolean checkNullAndEmpty(String value){
		if(value !=null && !value.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * replaceNullAndEmpty()
	 * @param  value
	 * @return String
	 */
	public String replaceNullAndEmpty(Object value){
		if(value == null || value.equals("")){
			value="--";
		}
		return value.toString();
	}
	
	/**
	 * checkIdledUser()
	 * 
	 * @param  currentDate
	 * @param  paramValue
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean checkIdledUser(String currentDate,Date lastLoggedDate,String paramValue) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		boolean isIdleUser = true;
		try{
			Calendar userCurrentDate = Calendar.getInstance();
			Calendar userExpiryDate = Calendar.getInstance();
			
			userCurrentDate.setTime(formatter.parse(currentDate));
			
			userExpiryDate.setTime(lastLoggedDate);
			userExpiryDate.add(Calendar.DATE, Integer.parseInt(paramValue));
			
			if(userExpiryDate.after(userCurrentDate)){
				isIdleUser = false;
			}
		}catch(Exception e){
			throw e;
		}
		return isIdleUser;
	}
}
