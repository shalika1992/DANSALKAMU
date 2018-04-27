package com.dansala.util.varlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonVarList {
	
	/*-------- Default status codes---------------------------*/
	@Autowired
	@Value("${status.default.active}")
	public String STATUS_DEFAULT_ACTIVE;
	
	@Autowired
	@Value("${status.default.deactive}")
	public String STATUS_DEFAULT_DEACTIVE;
	
	@Autowired
	@Value("${status.default.block}")
	public String STATUS_DEFAULT_BLOCK;
	
	/*-------- Default success code | fail codes--------------*/
	
	@Autowired
	@Value("${errorcode.success.code}")
	public String ERRORCODE_SUCCESS_CODE;
	
	@Autowired
	@Value("${errorcode.fail.code}")
	public String ERRORCODE_FAIL_CODE;
	
	/*-------- Default login codes-----------------------------*/
	
	@Autowired
	@Value("${user.reset.enable}")
	public String USER_RESET_ENABLE;
	
	@Autowired
	@Value("${user.reset.disable}")
	public String USER_RESET_DISABLE;
	
	@Autowired
	@Value("${user.firstlogin.enable}")
	public String USER_FIRSTLOGIN_ENABLE;
	
	@Autowired
	@Value("${user.firstlogin.disable}")
	public String USER_FIRSTLOGIN_DISABLE;
	
	/*-------- Default user param codes-----------------------------*/
	
	@Autowired
	@Value("${userparam.inactive.paramcode}")
	public String USERPARAM_INACTIVE_PARAMCODE;
	
	@Autowired
	@Value("${userparam.pincount.paramcode}")
	public String USERPARAM_PINCOUNT_PARAMCODE;
}
