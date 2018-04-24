package com.dansala.util.validator;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;

@Component
public class UserBeanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean data=(UserBean)target;
		try{
			Field[] allFields=data.getClass().getDeclaredFields();
		for (Field field : allFields) {			
			if(field.getName().equals("userName") && data.getUserName().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
			else if(field.getName().equals("password") && data.getPassword().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
			else if(field.getName().equals("phoneNumber") && data.getPhoneNumber().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
			else if(field.getName().equals("reEnterPassword") && data.getReEnterPassword().isEmpty()){
				errors.rejectValue(field.getName(), "frgeg");
			}
			
			else if(field.getName().equals("password") && !data.getPassword().isEmpty()){
				if(!data.getPassword().equals(data.getReEnterPassword())){
					errors.rejectValue(field.getName(), "frgeg");
				}
			}
			
		}
		

		}
		catch(Exception e){
			errors.reject("Error code");
		}

	}

}
