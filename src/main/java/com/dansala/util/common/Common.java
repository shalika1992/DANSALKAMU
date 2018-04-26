package com.dansala.util.common;

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
}
