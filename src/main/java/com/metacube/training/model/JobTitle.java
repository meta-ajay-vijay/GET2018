package com.metacube.training.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job_title_master")
public class JobTitle {

	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "job_title")
	private String jobTitle;

	@ManyToMany(mappedBy = "jobs")
	private List<Employee> employees;

	@ManyToMany(mappedBy = "jobs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Employee> teamLeaders = new LinkedHashSet<Employee>();

	public Collection<Employee> getTeamLeaders() {
		return teamLeaders;
	}

	public void setTeamLeaders(Collection<Employee> teamLeaders) {
		this.teamLeaders = teamLeaders;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

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

}
