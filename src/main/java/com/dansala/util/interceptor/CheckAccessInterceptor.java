package com.dansala.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dansala.bean.session.SessionBean;

public class CheckAccessInterceptor implements HandlerInterceptor{
	private final Log logger = LogFactory.getLog(getClass());
	
	private SessionBean sessionBean;
	
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		boolean isSessionBeanFound = false;
		try{
			if(sessionBean != null){
				isSessionBeanFound = true;
			}
		}catch(Exception e){
			logger.error("Exception :"+e);
		}
		return isSessionBeanFound;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		try{
			if(sessionBean != null){
				isSessionBeanFound = true;
			}
		}catch(Exception e){
			logger.error("Exception :"+e);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {}
}
