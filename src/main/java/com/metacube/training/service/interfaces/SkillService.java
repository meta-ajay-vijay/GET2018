package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.Skill;

public interface SkillService {

	List<Skill> getAllSkills();

	boolean createSkill(Skill skill);

	List<EmployeeModel> getEmployeesBySkills(String skill);
}