package com.dansala.bean.session;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("session")
public class SessionBean {
	private String sessionId;
	private String cif;
	private String userId;
	private String userName;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
