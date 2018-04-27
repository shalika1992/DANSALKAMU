package com.dansala.dao.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dansala.bean.icon.Icon;

@Repository
@Scope("prototype")
public class CommonDAOImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String GET_ICONS_SQL="SELECT ICONID,URL,FLAG FROM ICON WHERE FLAG=?";
	private final String GET_CURRENTDATE_SQL="SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') as CURRENTDATE";
	private final String GET_PWDPARAMVALUE_SQL="SELECT VALUE FROM PWDPARAM WHERE PARAMCODE=?";
	
	/**
	 * getIconList()
	 * @return List<Icon>
	 */
	public List<Icon> getIconList(){
		List<Icon> iconList =null;
		try {
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(GET_ICONS_SQL, 0);
			if (resultSet.size()> 0) {
				iconList=new ArrayList<>();
				for(Map<String,Object> record : resultSet){					
					Icon icon=new Icon();
					icon.setIconId ((int)record.get("ICONID"));
					icon.setUrl((String)record.get("URL"));
					icon.setFlag((int)record.get("FLAG"));
					iconList.add(icon);	
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return iconList;
	}
	
	/**
	 * getCurrentDate()
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getCurrentDate() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate;
		String currentDateInString;
		
		try {
			Map<String, Object> resultSet = jdbcTemplate.queryForMap(GET_CURRENTDATE_SQL);
			
			currentDate = formatter.parse(resultSet.get("CURRENTDATE").toString());
			currentDateInString = formatter.format(currentDate);
		}catch (Exception e) {
			throw e;
		}
		return currentDateInString;

	}
	
	/**
	 * getPwdParamValue()
	 * @param  paramCode
	 * @return String
	 */
	public String getPwdParamValue(String paramCode){
		String pwdParamValue ="0";
		try{
			Map<String, Object> resultSet = jdbcTemplate.queryForMap(GET_PWDPARAMVALUE_SQL,paramCode);
			if(resultSet.size() > 0){
				pwdParamValue=(String)resultSet.get("VALUE");
			}
		}catch (Exception e) {
			throw e;
		}
		return pwdParamValue;
	}
}
