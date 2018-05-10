package com.dansala.controller.home;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dansala.bean.dansala.DansalaBean;
import com.dansala.bean.dansalcategory.DansalCategory;
import com.dansala.bean.dansalcategory.DansalCategoryDTO;
import com.dansala.bean.icon.Icon;
import com.dansala.bean.json.DansalCategoryJSONRepons;
import com.dansala.bean.json.DansalaJSONRespons;
import com.dansala.bean.json.IconJSONRespons;
import com.dansala.bean.login.LoginBean;
import com.dansala.bean.message.Message;
import com.dansala.controller.dansala.DansalaController;
import com.dansala.dao.common.CommonDAOImpl;
import com.dansala.service.common.CommonServiceImpl;
import com.dansala.service.dansala.DansalaServiceImpl;
import com.dansala.service.dansalcategory.DansalCategoryServiceImpl;

@Controller
public class HomeController {

	@Autowired
	DansalaServiceImpl dansalaService;
	
	@Autowired
	CommonServiceImpl commonService;
	
	@Autowired
	DansalCategoryServiceImpl dansalCategoryService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/loadDansalaPage", method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		ModelAndView modelandview = new ModelAndView("login");
		try {
			List<DansalaBean> list = dansalaService.getDansalList();
			modelandview = new ModelAndView("dansalaPage", "list", list);
			modelandview.addObject("command", new DansalaBean());
		} catch (Exception e) {
			
		}
		return modelandview;
	}

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public ModelAndView loadHome() {
		return new ModelAndView("home");

	}

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public ModelAndView loadMap() {
		return new ModelAndView("map");

	}



	@RequestMapping(value = "/getAllDansalJSON", method = RequestMethod.POST)
	public @ResponseBody DansalaJSONRespons getAllDansal() {
		DansalaJSONRespons dansalaJSONRespons = new DansalaJSONRespons();
		try {

			List<DansalaBean> list = dansalaService.getDansalList();
			dansalaJSONRespons.setDansalAllList(list);
			dansalaJSONRespons.setMessage("SUCCESS");
		}

		catch (Exception e) {
			dansalaJSONRespons.setMessage("INVALID");
		}
		return dansalaJSONRespons;

	}
	@RequestMapping(value = "/getIconJSON", method = RequestMethod.POST)
	public @ResponseBody IconJSONRespons getIconJSON() {
		IconJSONRespons iconJSONRespons = new IconJSONRespons();
		try {

			List<Icon> list = commonService.getIconList();
			iconJSONRespons.setIconList(list);
			iconJSONRespons.setMessage("SUCCESS");
		}

		catch (Exception e) {
			iconJSONRespons.setMessage("INVALID");
		}
		return iconJSONRespons;

	}
	
	
	@RequestMapping(value = "/newCategoryJSON", method = RequestMethod.POST)
	public @ResponseBody Message  addNewCategory(DansalCategory  dansalCategory) {
		Message message=new Message();
		
		try {
			dansalCategoryService.addNewCategory(dansalCategory);
			message.setSuccessMsg("Succesfully added new category");
			
		}

		catch (Exception e) {
			message.setErrorMsg("Something is wrong");
		}
		return message;

	}
	

	@RequestMapping(value = "/getAllDansalCategoryJSON", method = RequestMethod.POST)
	public @ResponseBody DansalCategoryJSONRepons getAllDansalCategory() {
		DansalCategoryJSONRepons dansalaCategoryJSONRespons = new DansalCategoryJSONRepons();
		try {

			List<DansalCategoryDTO> list = dansalCategoryService.getAllDansal();
			dansalaCategoryJSONRespons.setDansalCategoryList(list);
			dansalaCategoryJSONRespons.setMessage("SUCCESS");
		}

		catch (Exception e) {
			dansalaCategoryJSONRespons.setMessage("INVALID");
		}
		return dansalaCategoryJSONRespons;

	}
	
	@RequestMapping(value = "/deleteDansalCategoryJSON", method = RequestMethod.POST)
	public @ResponseBody Message  deleteDansalCategory(int categoryId,int iconId) {
		Message message=new Message();
		
		try {
			if(dansalCategoryService.deleteCategory(categoryId, iconId)){
				message.setSuccessMsg("Succesfully deleted category");
			}
			else{
				message.setErrorMsg("Something is wrong");
			}
		}

		catch (Exception e) {
			message.setErrorMsg("Something is wrong");
		}
		return message;

	}
	

}
