package com.dansala.test.service.common;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dansala.bean.icon.Icon;
import com.dansala.dao.common.CommonDAOImpl;



@Component
public class CommonServiceTest {
	
	@Autowired
	CommonDAOImpl commonDAO;
	
	@Given("get icon list")
	 public void givenGetDansalaList(){
		try {
			List<Icon>list= commonDAO.getIconList();
			Assert.assertNotNull(list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
