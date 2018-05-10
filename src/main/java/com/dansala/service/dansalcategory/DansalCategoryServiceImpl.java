package com.dansala.service.dansalcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.dansalcategory.DansalCategory;
import com.dansala.bean.dansalcategory.DansalCategoryDTO;
import com.dansala.dao.dansala.DansalaDAOImpl;
import com.dansala.dao.dansalcategory.DansalCategoryDAOImpl;

@Repository
@Scope("prototype")
public class DansalCategoryServiceImpl {
	
	@Autowired
	DansalCategoryDAOImpl dansalaCategoryDAO;
	
	public boolean addNewCategory(DansalCategory dansalCategory){
		return dansalaCategoryDAO.addNewCategory(dansalCategory);
	}
	
	public  List<DansalCategoryDTO> getAllDansal(){
		return dansalaCategoryDAO.getAllDansalCategory();
	}
	
	public boolean deleteCategory(int categoryId, int iconId){
		return dansalaCategoryDAO.deleteCategory(categoryId, iconId);
	}

}
