package com.dansala.util.validator;


import java.lang.reflect.Field;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dansala.bean.login.LoginBean;


@Component
public class LoginBeanValidator implements Validator {
	


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginBean data=(LoginBean)target;
		try{
			Field[] allFields=data.getClass().getDeclaredFields();
		for (Field field : allFields) {			
			if(field.getName().equals("userName") && data.getUserName().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
			else if(field.getName().equals("password") && data.getPassword().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
		}
		}
		catch(Exception e){
			errors.reject("Error code");
		}
		
	}

}
