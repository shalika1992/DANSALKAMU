package com.dansala.service.dansala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.dao.dansala.DansalaDAOImpl;
@Repository
@Scope("prototype")
public class DansalaServiceImpl {
	
	@Autowired
	DansalaDAOImpl dansalaDAO;
	
	 public List<DansalaBean> getDansalList(){

			try {
				return dansalaDAO.getDansalList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

	}
	 
	 public DansalaBean addDansala(DansalaBean dansalaBean){
		 
		 return dansalaDAO.addDansala(dansalaBean);
	 }
	

}
