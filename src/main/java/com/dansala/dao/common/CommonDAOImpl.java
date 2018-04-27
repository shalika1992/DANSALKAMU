package com.dansala.dao.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private final Log logger = LogFactory.getLog(getClass());
	private final String GET_ICONS_SQL="SELECT ICONID,URL,FLAG FROM ICON WHERE FLAG=?";
	
	/**
	 * getIconList()
	 * @return List<Icon>
	 */
	public List<Icon> getIconList(){
		try {
			List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(GET_ICONS_SQL, 0);
			if (resultSet.size()> 0) {
				List<Icon> iconList=new ArrayList<>();
				for(Map<String,Object> record : resultSet){					
					Icon icon=new Icon();
					icon.setIconId ((int)record.get("ICONID"));
					icon.setUrl((String)record.get("URL"));
					icon.setFlag((int)record.get("FLAG"));
					iconList.add(icon);	
				}
				return iconList;
			}
		} catch (Exception e) {
			logger.error("Exception  :  " , e);
			throw e;
		}
		
		return null;
	}

}
