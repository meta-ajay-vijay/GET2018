package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.interfaces.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private ProjectRepository projectRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public Project getProjectById(Long id) {
		return (Project) projectRepository.findOne(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteProject(Long id) {
		projectRepository.delete(id);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateProject(Project project) {
		projectRepository.save(project);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean createProject(Project project) {	
		projectRepository.save(project);
		return true;
	}
}