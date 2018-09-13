package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.JobTitleDAO;
import com.metacube.training.model.JobTitle;
import com.metacube.training.service.interfaces.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService {
	
	@Autowired
	private JobTitleDAO jobTitleDao;
	

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jobTitleDao.getAllJobTitle();
	}

	@Override
	public boolean deleteJobTitle(int id) {
		// TODO Auto-generated method stub
		return jobTitleDao.deleteJobTitle(id);
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return jobTitleDao.updateJobTitle(jobTitle);
	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return jobTitleDao.createJobTitle(jobTitle);
	}

	@Override
	public JobTitle getJobTitleById(int id) {
		// TODO Auto-generated method stub
		return jobTitleDao.getJobTitleById(id);
	}

}
