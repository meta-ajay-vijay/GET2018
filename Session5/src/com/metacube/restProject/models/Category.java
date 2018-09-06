package com.metacube.restProject.models;

public class Category extends BaseEntity {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	private String categoryName;

/*	public Category(int id, String categoryName) {
		super(id);
		this.categoryName = categoryName;
	}*/

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + "]";
	}



}
