package com.dansala.controller.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.bean.login.LoginBean;
import com.dansala.bean.session.SessionBean;
import com.dansala.dao.dansala.impl.DansalaDAOImpl;


@Controller
public class HomeController {
	
	/*@Autowired
	SessionBean sessionBean;*/
	

	
	@Autowired
    DansalaDAOImpl  dansalaDAO;
	
	@RequestMapping(value="/loadDansalaPage", method=RequestMethod.GET)
	public ModelAndView loadLoginPage() {
	/*	return new ModelAndView("dansalaPage");*/
		ModelAndView modelandview = new ModelAndView("login");
		try{
			/*	sessionBean.setUserId("1");*/
				List<DansalaBean> list= dansalaDAO.getDansalList();
				modelandview = new ModelAndView("dansalaPage","list",list);
		}catch(Exception e){

		}
		return modelandview;
	}
	@RequestMapping(value="/homePage", method=RequestMethod.GET)
	public ModelAndView loadHome(){	
		return new ModelAndView("home");
		
	}
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public ModelAndView loadMap(){	
		return new ModelAndView("map");
		
	}
	

	@RequestMapping(value="/loginaa", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("LoginBean")LoginBean LoginBean,ModelMap modelMap){		
		ModelAndView modelandview = new ModelAndView("login");
		
		try{
			/*	sessionBean.setUserId("1");*/
				List<DansalaBean> list= dansalaDAO.getDansalList();
				modelandview = new ModelAndView("loginaa","list",list);
		}catch(Exception e){

		}
		return modelandview;
	}

}
