package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {

	List<Skill> getAllSkills();
	boolean createSkill(Skill skill);

}
