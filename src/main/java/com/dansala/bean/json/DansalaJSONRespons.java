package com.dansala.bean.json;

import java.util.List;

import com.dansala.bean.dansala.DansalaBean;

public class DansalaJSONRespons {
	private List<DansalaBean> dansalAllList;
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
	 * @return the dansalAllList
	 */
	public List<DansalaBean> getDansalAllList() {
		return dansalAllList;
	}

	/**
	 * @param dansalAllList the dansalAllList to set
	 */
	public void setDansalAllList(List<DansalaBean> dansalAllList) {
		this.dansalAllList = dansalAllList;
	}
}
