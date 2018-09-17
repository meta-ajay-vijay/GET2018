package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setDateOfJoining(resultSet.getDate("doj"));
		employee.setContactNumber(resultSet.getString("primary_contact_number"));
		employee.setPassword(resultSet.getString("password"));
		employee.setGender(resultSet.getString("gender"));
		return employee;
	}

	
}
