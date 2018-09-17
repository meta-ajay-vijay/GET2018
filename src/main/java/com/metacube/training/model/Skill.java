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

@Entity
@Table(name= "skill_master")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	int id;
	
	@Column(name = "skill_name") 
	String name;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
        name = "employee_skill",
        joinColumns = { @JoinColumn(name = "skill_id") },
        inverseJoinColumns = { @JoinColumn(name = "emp_code") }
    )
//	@Where(clause = "job_title = 'Team Leader'") 
	private List<EmployeeModel> employeesSkills;

	public List<EmployeeModel> getEmployeesSkills() {
		return employeesSkills;
	}

	public void setEmployeesSkills(List<EmployeeModel> employeesSkills) {
		this.employeesSkills = employeesSkills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}