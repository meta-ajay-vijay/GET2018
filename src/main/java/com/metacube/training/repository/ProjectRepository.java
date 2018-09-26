package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Long> {

}
