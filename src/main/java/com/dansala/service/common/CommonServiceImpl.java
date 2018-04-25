package com.dansala.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.icon.Icon;
import com.dansala.bean.login.LoginBean;
import com.dansala.bean.user.UserBean;
import com.dansala.dao.authenticate.AuthenticateDAOImpl;
import com.dansala.dao.common.CommonDAOImpl;

@Repository
@Scope("prototype")
public class CommonServiceImpl {
	
	@Autowired
	CommonDAOImpl commonDAO;
	
	public List<Icon> getIconList(){
	
		return commonDAO.getIconList();
	}
	
	

}
