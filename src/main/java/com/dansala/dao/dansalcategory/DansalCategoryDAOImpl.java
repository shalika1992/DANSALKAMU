package com.dansala.dao.dansalcategory;

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
import com.dansala.bean.dansalcategory.DansalCategory;
import com.dansala.bean.dansalcategory.DansalCategoryDTO;


@Repository
@Scope("prototype")
public class DansalCategoryDAOImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final Log logger = LogFactory.getLog(getClass());
	private final String addDansalaCategorySql  ="INSERT INTO DANSALCATEGORY(TYPE,ICONID) VALUES(?,?)";
	private final String updateIconTable="UPDATE ICON SET FLAG=? WHERE ICONID=?";
	private final String getAllDansalSql="SELECT DC.CATEGORYID AS CATEGORYID ,DC.TYPE AS TYPE,DC.ICONID AS ICONID,ICON.URL AS URL FROM DANSALCATEGORY DC INNER JOIN "
						+" ICON ON DC.ICONID=ICON.ICONID";
										
	public boolean addNewCategory(DansalCategory  dansalCategory){
		Object [] parameters = {dansalCategory.getType(),dansalCategory.getIconId()};
		List<DansalCategoryDTO> dansalcategoryDTOList=getAllDansalCategory();
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
	
	
	public List<DansalCategoryDTO> getAllDansalCategory(){
		List<DansalCategoryDTO> dansalcategoryDTOList=new ArrayList<DansalCategoryDTO>();
		try{
			
			List<Map<String, Object>> resultSet=jdbcTemplate.queryForList(getAllDansalSql,new Object[] {});
			
			if(!resultSet.isEmpty()){
				for(Map<String,Object> record : resultSet){
					DansalCategoryDTO dansalaCategoryDTO=new DansalCategoryDTO();
					
					dansalaCategoryDTO.setCategoryId((int)record.get("CATEGORYID"));
					dansalaCategoryDTO.setType((String)record.get("TYPE"));
					dansalaCategoryDTO.setIconId((int)record.get("ICONID"));
					dansalaCategoryDTO.setUrl((String)record.get("URL"));
					dansalcategoryDTOList.add(dansalaCategoryDTO);

				}
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return dansalcategoryDTOList;
		
	}
}