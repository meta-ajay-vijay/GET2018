package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_skill_id")
	private int empSkillId;
	

	@Column(name = "emp_code")
	private String empCode;
	
	@Column(name="skill_id")
	private int skillId;

	
	public int getEmpSkillId() {
		return empSkillId;
	}

	public void setEmpSkillId(int empSkillId) {
		this.empSkillId = empSkillId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
}