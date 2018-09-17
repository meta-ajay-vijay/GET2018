package com.metacube.training.transferObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.metacube.training.model.Skill;



public class EmployeeSkills {
	
	private String empCode;
	
	private Set<Integer> skills = new HashSet();

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Set<Integer> getSkills() {
		return skills;
	}

	public void setSkills(Set<Integer> skills) {
		this.skills = skills;
	}
}
