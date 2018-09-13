package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobTitleDAO {
	List<JobTitle> getAllJobTitle();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	boolean createJobTitle(JobTitle jobTitle);
	
	JobTitle getJobTitleById(int id);
}
