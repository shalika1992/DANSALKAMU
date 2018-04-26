package com.dansala.bean.json;

import java.util.List;

import com.dansala.bean.dansala.DansalaBean;
import com.dansala.bean.icon.Icon;

public class IconJSONRespons {
	
	private List<Icon> iconList;
	private String message;
	/**
	 * @return the dansalAllList
	 */
	
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
	 * @return the iconList
	 */
	public List<Icon> getIconList() {
		return iconList;
	}
	/**
	 * @param iconList the iconList to set
	 */
	public void setIconList(List<Icon> iconList) {
		this.iconList = iconList;
	}

}
