package com.dansala.util.common;

import org.springframework.stereotype.Component;

@Component
public class Common {
	public boolean checkNullAndEmpty(String value){
		if(value !=null && !value.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public String replaceNullAndEmpty(Object value){
		if(value == null || value.equals("")){
			value="--";
		}
		return value.toString();
	}
}
