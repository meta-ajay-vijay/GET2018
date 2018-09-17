package com.metacube.training.service.serviceinterface;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.transferObjects.EmployeeSkills;

public interface SkillService {
		
	Skill getSkillById(Long id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Long id);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
}
