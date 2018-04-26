package com.dansala.util.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

import com.dansala.bean.login.LoginBean;
import com.dansala.util.varlist.MessageVarList;

@Component
public class LoginBeanValidator implements Validator {
	@Autowired
	protected MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> cls) {
		return LoginBean.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Locale locale = Locale.getDefault();
		LoginBean loginBean = (LoginBean) target;
		
		Field[] requiredFields = null;
		String message = "";
		
		SortedMap<String, Field> allFields = new TreeMap<>();
		for (Field field : loginBean.getClass().getDeclaredFields()) {
			allFields.put(field.getName(), field);
		}
		
		requiredFields = new Field[] { allFields.get("userName"), allFields.get("password")};
		
		try {
			for (Field field : requiredFields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				if (fieldName.equals("userName")) {
					message = messageSource.getMessage(MessageVarList.LOGIN_USERNAME_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				} else if (fieldName.equals("password")) {
					message = messageSource.getMessage(MessageVarList.LOGIN_PASSWORD_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				} 
			}
		} catch (Exception e) {
			errors.reject("ERRORCODE");
		}
	}
}