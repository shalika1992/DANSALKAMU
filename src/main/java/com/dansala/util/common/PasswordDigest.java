package com.dansala.util.common;

import java.util.Base64;

public class PasswordDigest {
	/**
	 * encodeToBase64()
	 * 
	 * @param  password
	 * @return String
	 * @throws Exception
	 */
	public static String encodeToBase64(String password) {
		try{
			byte[] encodedBytes = Base64.getEncoder().encode("supul@123".getBytes());
	        return new String(encodedBytes);
		}catch(Exception e){
			throw e;
		}
	}
}
