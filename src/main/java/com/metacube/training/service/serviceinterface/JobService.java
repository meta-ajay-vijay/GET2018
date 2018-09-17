package com.metacube.training.service.serviceinterface;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {
		
	Job getJobById(Long id);

	List<Job> getAllJobs();

	boolean deleteJob(Long id);

	boolean updateJob(Job job);

	boolean createJob(Job job);

}
