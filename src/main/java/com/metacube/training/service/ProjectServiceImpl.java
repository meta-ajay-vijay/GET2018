package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.interfaces.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProjectById(Long id) {

		return (Project) projectRepository.findOne(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteProject(Long id) {
		projectRepository.delete(id);
		return true;
	}

	@Override
	public boolean updateProject(Project project) {
		projectRepository.save(project);
		return true;
	}

	@Override
	public boolean createProject(Project project) {
		projectRepository.save(project);
		return true;
	}

}