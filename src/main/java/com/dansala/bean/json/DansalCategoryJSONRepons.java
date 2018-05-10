package com.dansala.bean.json;

import java.util.List;

import com.dansala.bean.dansalcategory.DansalCategoryDTO;

public class DansalCategoryJSONRepons {
	
	
	private List<DansalCategoryDTO> dansalCategoryList;
	private String message;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the dansalCategoryList
	 */
	public List<DansalCategoryDTO> getDansalCategoryList() {
		return dansalCategoryList;
	}

	/**
	 * @param dansalCategoryList the dansalCategoryList to set
	 */
	public void setDansalCategoryList(List<DansalCategoryDTO> dansalCategoryList) {
		this.dansalCategoryList = dansalCategoryList;
	}

	

}
