package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.JobTitleDAO;
import com.metacube.training.mappers.JobTitleMapper;
import com.metacube.training.model.JobTitle;
@Repository
public class JobTitleDAOImpl implements JobTitleDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobTitleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	private final String SQL_DELETE_JOB_TITLE = "delete from job_title_master where job_id = ?";
	private final String SQL_UPDATE_JOB_TITLE = "update job_title_master set job_title = ? where job_id = ?";
	private final String SQL_GET_ALL = "select * from job_title_master";
	private final String SQL_INSERT_JOB_TITLE = "insert into job_title_master(job_title) values(?)";
	private final String SQL_GET_JOB_BY_ID = "SELECT *FROM job_title_master WHERE job_id = ? ";

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobTitleMapper());
	}

	@Override
	public boolean deleteJobTitle(int id) {
		return jdbcTemplate.update(SQL_DELETE_JOB_TITLE, id) > 0;
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_UPDATE_JOB_TITLE, jobTitle.getId()) > 0;

	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_INSERT_JOB_TITLE, jobTitle.getJobTitle())>0;
	}

	@Override
	public JobTitle getJobTitleById(int id) {
		return jdbcTemplate.queryForObject(SQL_GET_JOB_BY_ID, new Object[] { id }, new JobTitleMapper());
	}
	
	

}
