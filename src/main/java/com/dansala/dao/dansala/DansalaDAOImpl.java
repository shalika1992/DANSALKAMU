package com.dansala.dao.dansala;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.util.common.Common;
import com.dansala.util.varlist.CommonVarList;


@Repository
@Scope("prototype")
public class DansalaDAOImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CommonVarList commonVarList;
	
	@Autowired
	Common common;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	private final String sqlDansalaList ="SELECT ID,NAME,LONGITUDE,LATITUDE FROM DANSAL";
	private final String sqlAddDansala  ="INSERT INTO DANSAL(NAME,LONGITUDE,LATITUDE) VALUES(?,?,?)";
	

	public List<DansalaBean> getDansalList() throws Exception {
		List<DansalaBean> dansalList=new ArrayList<DansalaBean>();
		try{
			
			List<Map<String, Object>> resultSet=jdbcTemplate.queryForList(sqlDansalaList,new Object[] {});
			
			if(!resultSet.isEmpty()){
				for(Map<String,Object> record : resultSet){
					DansalaBean dansalaBean=new DansalaBean();
					
					dansalaBean.setId((int)record.get("ID"));
					dansalaBean.setName((String)record.get("NAME"));
					dansalaBean.setLatitude((Float)record.get("LATITUDE"));
					dansalaBean.setLongitude((Float)record.get("LONGITUDE"));
					dansalList.add(dansalaBean);

				}
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return dansalList;
	}
	
	public DansalaBean addDansala(DansalaBean dansalaBean){
		Object [] parameters = {dansalaBean.getName(),dansalaBean.getLongitude(),dansalaBean.getLatitude()};
		try {
			int rows = jdbcTemplate.update(sqlAddDansala, parameters);

			if (rows == 1) {
				return dansalaBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception  :  " , e);
			throw e;
		}
		

	}
}