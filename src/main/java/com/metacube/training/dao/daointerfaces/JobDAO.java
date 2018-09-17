package com.metacube.training.dao.daointerfaces;

import java.util.List;

import com.metacube.training.model.Job;



public interface JobDAO {
	Job getJobById(Long id);

	List<Job> getAllJobs();

	boolean deleteJob(Job job);

	boolean updateJob(Job job);

	boolean createJob(Job job);
	
}
