package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.EmployeeSkillRepository;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.interfaces.EmployeeSkillService;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

	@Autowired
	EmployeeRepository<Employee> employeeRepository;

	@Autowired
	SkillRepository<Skill> skillRepository;

	@SuppressWarnings("rawtypes")
	@Autowired
	EmployeeSkillRepository employeeSkillRepository;

	@SuppressWarnings("unchecked")
	@Override
	public void addSkillsToEmployee(String empCode, String[] skillId) {
		try {
			for (int index = 0; index < skillId.length; index++) {
				EmployeeSkills employeeSkills = new EmployeeSkills();
				employeeSkills.setEmpCode(empCode);
				employeeSkills.setSkillId(Long.parseLong(skillId[index]));
				employeeSkillRepository.save(employeeSkills);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
