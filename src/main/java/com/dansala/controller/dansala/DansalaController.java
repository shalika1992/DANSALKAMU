package com.dansala.controller.dansala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.bean.login.LoginBean;
import com.dansala.dao.dansala.DansalaDAOImpl;

@Controller
public class DansalaController {
	
	@Autowired
    DansalaDAOImpl  dansalaDAO;
	
	
	@RequestMapping(value="/addDansala", method=RequestMethod.POST)
	public ModelAndView addDansala(@ModelAttribute("DansalaBean")DansalaBean dansalaBean,ModelMap modelMap) {
		ModelAndView modelandview=new ModelAndView();
		try{
			dansalaDAO.adddansala(dansalaBean);
			List<DansalaBean> list= dansalaDAO.getDansalList();
			modelandview = new ModelAndView("dansalaPage","list",list);
			modelandview.addObject("command",new DansalaBean());
		}
		
		catch(Exception e){
			
		}
		return modelandview;
	}

}
