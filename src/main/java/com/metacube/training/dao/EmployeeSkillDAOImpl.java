package com.metacube.training.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.EmployeeSkillDAO;
import com.metacube.training.model.EmployeeSkills;

@Transactional
@Repository
public class EmployeeSkillDAOImpl implements EmployeeSkillDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;

	
	@Override
	public void addSkillsToEmployee(String empCode, String[] skillId) {
		for(int i = 0; i<skillId.length;i++){
			EmployeeSkills employeeSkills = new EmployeeSkills();
			System.out.println(empCode + ": " + skillId[i]);
			employeeSkills.setEmpCode(empCode);
			employeeSkills.setSkillId(Integer.parseInt(skillId[i]));
			sessionFactory.getCurrentSession().save(employeeSkills);
		}

	}

}