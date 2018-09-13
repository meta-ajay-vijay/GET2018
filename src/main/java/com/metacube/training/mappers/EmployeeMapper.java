package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPrimaryContactNumber(resultSet.getString("primary_contact_number"));
		employee.setSecondaryContactNumber(resultSet.getString("secondary_contact_number"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setSkypeId(resultSet.getString("skype_id"));
		employee.setProfilePicture(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));
		employee.setEnabled(resultSet.getBoolean("enabled"));
		employee.setToken(resultSet.getString("token"));
		return employee;
	}

}
