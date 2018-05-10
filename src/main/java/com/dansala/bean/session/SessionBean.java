package com.dansala.bean.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dansala.bean.user.UserBean;

@Component
@Scope("session")
public class SessionBean {
	private String sessionId;
	private String cif;
	private String userId;
	private String userName;
	private UserBean userBean;
	
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
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}
