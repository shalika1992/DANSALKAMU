package com.dansala.dao.dansalcategory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dansala.bean.dansalcategory.DansalCategory;


@Repository
@Scope("prototype")
public class DansalCategoryDAOImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final Log logger = LogFactory.getLog(getClass());
	private final String addDansalaCategorySql  ="INSERT INTO DANSALCATEGORY(TYPE,ICONID) VALUES(?,?)";
	private final String updateIconTable="UPDATE ICON SET FLAG=? WHERE ICONID=?";
	public boolean addNewCategory(DansalCategory  dansalCategory){
		Object [] parameters = {dansalCategory.getType(),dansalCategory.getIconId()};
		try {
			int rows = jdbcTemplate.update(addDansalaCategorySql, parameters);

			if (rows == 1) {
				rows = jdbcTemplate.update(updateIconTable, 1,dansalCategory.getIconId());
				if(rows==1){
					return true;
				}
				else{
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception  :  " , e);
			throw e;
		}
		

	}
}
