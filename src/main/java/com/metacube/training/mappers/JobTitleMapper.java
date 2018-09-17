package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.JobTitle;

public class JobTitleMapper implements RowMapper<JobTitle> {

	@Override
	public JobTitle mapRow(ResultSet resultSet, int i) throws SQLException {
		JobTitle jobTitle = new JobTitle();
		jobTitle.setId(resultSet.getInt("job_id"));
		jobTitle.setJobTitle(resultSet.getString("job_title"));
		return jobTitle;
	}
}
