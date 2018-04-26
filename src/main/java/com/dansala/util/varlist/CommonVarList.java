package com.dansala.util.varlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonVarList {
	
	@Autowired
	@Value("${status.default.active}")
	public String STATUS_DEFAULT_ACTIVE;
	
	@Autowired
	@Value("${status.default.deactive}")
	public String STATUS_DEFAULT_DEACTIVE;
	
	@Autowired
	@Value("${errorcode.success.code}")
	public String ERRORCODE_SUCCESS_CODE;
	
	@Autowired
	@Value("${errorcode.fail.code}")
	public String ERRORCODE_FAIL_CODE;
}
