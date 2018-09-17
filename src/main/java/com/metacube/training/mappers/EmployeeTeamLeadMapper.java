package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeAndJobDetails;

public class EmployeeTeamLeadMapper implements RowMapper<EmployeeAndJobDetails> {

	@Override
	public EmployeeAndJobDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
		employeeAndJobDetails.setEmpCode(resultSet.getString("emp_code"));
		employeeAndJobDetails.setFirstName(resultSet.getString("first_name"));
		return employeeAndJobDetails;
	}
}
