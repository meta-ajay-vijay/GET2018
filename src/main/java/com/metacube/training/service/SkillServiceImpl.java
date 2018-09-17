package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.Skill;
import com.metacube.training.service.interfaces.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillDAO skillDAO;

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}

	@Override
	public List<EmployeeModel> getEmployeesBySkills(String skill) {
		return skillDAO.getEmployeesBySkills(skill);
	}
}