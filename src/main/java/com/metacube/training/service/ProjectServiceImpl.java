package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.serviceinterface.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	/*@Autowired
	private ProjectDAO projectDAO;*/
	
	@Autowired
    private ProjectRepository<Project> projectRepository;

	
	
	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findOne(id);
		//projectDAO.getProjectById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteProject(Long id) {
		try{
				projectRepository.delete(id);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		//Project project = projectDAO.getProjectById(id);
		return true;//projectDAO.deleteProject(project);
	}

	@Override
	public boolean updateProject(Project project) {
		try{
		projectRepository.save(project);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;//projectDAO.updateProject(project);
	}

	@Override
	public boolean createProject(Project project) {
		try{
		projectRepository.save(project);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
