package com.dansala.service.common;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.icon.Icon;
import com.dansala.dao.common.CommonDAOImpl;

@Repository
@Scope("prototype")
public class CommonServiceImpl {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	CommonDAOImpl commonDAO;
	
	/**
	 * getIconList()
	 * @return
	 */
	public List<Icon> getIconList(){
		try{
			return commonDAO.getIconList();
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}
	
	/**
	 * getCurrentDate()
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getCurrentDate() throws Exception {
		try {
			return commonDAO.getCurrentDate();
		}catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	/**
	 * getPwdParamValue()
	 * @param  paramCode
	 * @return String
	 */
	public String getPwdParamValue(String paramCode){
		try {
			return commonDAO.getPwdParamValue(paramCode);
		}catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
