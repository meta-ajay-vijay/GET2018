package com.metacube.restProject.models;

public class Advertisment extends BaseEntity {
	private String advertismentTitle;
	private String advertismentDescription;
	private int categoryId;

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}





	/**
	 * @return the advertismentTitle
	 */
	public String getAdvertismentTitle() {
		return advertismentTitle;
	}

	/**
	 * @param advertismentTitle
	 *            the advertismentTitle to set
	 */
	public void setAdvertismentTitle(String advertismentTitle) {
		this.advertismentTitle = advertismentTitle;
	}

	/**
	 * @return the advertismentDescription
	 */
	public String getAdvertismentDescription() {
		return advertismentDescription;
	}

	/**
	 * @param advertismentDescription
	 *            the advertismentDescription to set
	 */
	public void setAdvertismentDescription(String advertismentDescription) {
		this.advertismentDescription = advertismentDescription;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Advertisment [advertismentTitle=" + advertismentTitle
				+ ", advertismentDescription=" + advertismentDescription
				+ ", categoryId=" + categoryId + "]";
	}



}
