package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.daointerfaces.JobDAO;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.serviceinterface.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
    private JobRepository<Job> jobRepository;

	@Override
	public boolean deleteJob(Long id) {
		return false;
	}


	@Override
	public Job getJobById(Long id) {
		
		return jobRepository.findOne(id);
	}


	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean createJob(Job job) {
		try{
			jobRepository.save(job);
		}catch(Exception e)
		{
			e.fillInStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}
}
