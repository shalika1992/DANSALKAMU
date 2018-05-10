package com.dansala.bean.dansalcategory;

public class DansalCategoryDTO {

	private int categoryId;
	private String type;
	private int iconId;
	private String url;
	
	
	/**
	 * @return the categotyId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the iconId
	 */
	public int getIconId() {
		return iconId;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param categotyId the categotyId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param iconId the iconId to set
	 */
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
