package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.EmployeeSkillDAO;
import com.metacube.training.service.interfaces.EmployeeSkillService;

@Service 
public class EmployeeSkillServiceImpl implements EmployeeSkillService{
	@Autowired
	EmployeeSkillDAO employeeSkillDAO;
	
	@Override
	public void addSkillsToEmployee(String empCode, String[] skillId) {
		employeeSkillDAO.addSkillsToEmployee(empCode, skillId);
	}

}