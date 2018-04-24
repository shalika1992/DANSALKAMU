package com.dansala.test.service.dansala;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.dao.dansala.DansalaDAOImpl;

@Component
public class DansalaServiceTest {
	@Autowired
	DansalaDAOImpl dansalaDAO;
	
	@Given("get dansala list")
	 public void givenGetDansalaList(){
		try {
			List<DansalaBean>list= dansalaDAO.getDansalList();
			Assert.assertNotNull(list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
