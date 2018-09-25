package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.interfaces.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	SkillRepository skillRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	@Override
	public List<Employee> getEmployeesBySkills(String skill) {	
		return skillRepository.getSkillByName(skill).getEmployeesSkills();
	}
}
