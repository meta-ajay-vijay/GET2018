package com.metacube.userLogin.view;

public class ProfileView {
	private String name;
	private int age;
	private String contact;
	private String orgnization;
	private String imageUrl;


	public ProfileView(String name, int age, String contact,
			String orgnization, String imageUrl) {
		super();
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.orgnization = orgnization;
		this.imageUrl = imageUrl;
	}



/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfileView [name=" + name + ", age=" + age + ", contact="
				+ contact + ", orgnization=" + orgnization + ", imageUrl="
				+ imageUrl + "]";
	}



/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the age
 */
public int getAge() {
	return age;
}
/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}
/**
 * @return the contact
 */
public String getContact() {
	return contact;
}
/**
 * @param contact the contact to set
 */
public void setContact(String contact) {
	this.contact = contact;
}
/**
 * @return the orgnization
 */
public String getOrgnization() {
	return orgnization;
}
/**
 * @param orgnization the orgnization to set
 */
public void setOrgnization(String orgnization) {
	this.orgnization = orgnization;
}

/**
 * @return the imageUrl
 */
public String getImageUrl() {
	return imageUrl;
}
/**
 * @param imageUrl the imageUrl to set
 */
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


}
