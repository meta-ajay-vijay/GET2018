package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "job_title_master")
public class JobTitle {
	
	@Id
	@Column(name = "job_id")
	private int id;
	
	@Column(name = "job_title")
	private String jobTitle;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Override
	public String toString() {
		return "JobTitle [id=" + id + ", jobTitle=" + jobTitle + "]";
	}
	
}
