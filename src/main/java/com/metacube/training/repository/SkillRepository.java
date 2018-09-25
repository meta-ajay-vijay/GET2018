package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.Skill;

public interface SkillRepository<S> extends JpaRepository<Skill, Long> {

	public Skill getSkillByName(String name);
}
