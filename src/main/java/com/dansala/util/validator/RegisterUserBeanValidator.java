package com.dansala.util.validator;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dansala.bean.register.RegisterUserBean;
import com.dansala.util.varlist.MessageVarList;

@Component
public class RegisterUserBeanValidator implements Validator {
	@Autowired
	protected MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> cls) {
		return RegisterUserBean.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Locale locale = Locale.getDefault();
		RegisterUserBean registerUserBean = (RegisterUserBean) target;
		
		Field[] requiredFields = null;
		String message = "";
		
		SortedMap<String, Field> allFields = new TreeMap<>();
		for (Field field : registerUserBean.getClass().getDeclaredFields()) {
			allFields.put(field.getName(), field);
		}
		
		requiredFields = new Field[] { allFields.get("userName"), allFields.get("email"),allFields.get("phoneNumber"), allFields.get("password"), allFields.get("reEnterPassword")};

		try {
			for (Field field : requiredFields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				if (fieldName.equals("userName")) {
					message = messageSource.getMessage(MessageVarList.REGISTRATION_USERNAME_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				}else if (fieldName.equals("email")) {
					message = messageSource.getMessage(MessageVarList.REGISTRATION_EMAIL_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				}else if (fieldName.equals("phoneNumber")) {
					message = messageSource.getMessage(MessageVarList.REGISTRATION_PHONENO_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				}else if (fieldName.equals("password")) {
					message = messageSource.getMessage(MessageVarList.REGISTRATION_PASSWORD_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				}else if (fieldName.equals("reEnterPassword")) {
					message = messageSource.getMessage(MessageVarList.REGISTRATION_REENTERPASSWORD_EMPTY, null, locale);
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, fieldName, fieldName, message);
				} 
			}
		} catch (Exception e) {
			errors.reject("Error code");
		}
	}

}
