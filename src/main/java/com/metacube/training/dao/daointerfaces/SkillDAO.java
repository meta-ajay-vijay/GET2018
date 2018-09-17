package com.metacube.training.dao.daointerfaces;

import java.util.List;

import com.metacube.training.model.Skill;


public interface SkillDAO {
	Skill getSkillById(Long id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
	
}
