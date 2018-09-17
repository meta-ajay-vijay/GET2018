package com.metacube.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


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
    private List<EmployeeModel> employees;

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
        name = "job_details",
        joinColumns = { @JoinColumn(name = "job_id") },
        inverseJoinColumns = { @JoinColumn(name = "emp_code") }
    )
//	@Where(clause = "job_title = 'Team Leader'") 
	private List<EmployeeModel> teamLeaders;


	public List<EmployeeModel> getTeamLeaders() {
		return teamLeaders;
	}

	public void setTeamLeaders(List<EmployeeModel> teamLeaders) {
		this.teamLeaders = teamLeaders;
	}

	public List<EmployeeModel> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeModel> employees) {
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