package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillRepository<E> extends JpaRepository<EmployeeSkills, Long> {

}