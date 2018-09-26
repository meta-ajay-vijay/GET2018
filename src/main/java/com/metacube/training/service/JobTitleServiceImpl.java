package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;
import com.metacube.training.service.interfaces.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jobTitleRepository.findAll();
	}

	@Override
	public boolean deleteJobTitle(int id) {
		jobTitleRepository.delete(id);
		return true;
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}

	@Override
	public JobTitle getJobTitleById(int id) {
		return (JobTitle) jobTitleRepository.findOne(id);
	}
}
