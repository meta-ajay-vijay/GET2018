package com.metacube.restProject.models;

public class BaseEntity {
	private int id;

/*	public BaseEntity(int id) {
		super();
		this.id = id;
	}*/

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
