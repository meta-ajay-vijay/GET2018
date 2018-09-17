package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeModel;

public class EmployeeMapper implements RowMapper<EmployeeModel> {

	@Override
	public EmployeeModel mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setEmpCode(resultSet.getString("emp_code"));
		employeeModel.setFirstName(resultSet.getString("first_name"));
		employeeModel.setLastName(resultSet.getString("last_name"));
		employeeModel.setDob(resultSet.getDate("dob"));
		employeeModel.setGender(resultSet.getString("gender"));
		employeeModel.setPrimaryContactNumber(resultSet.getString("primary_contact_number"));
		employeeModel.setSecondaryContactNumber(resultSet.getString("secondary_contact_number"));
		employeeModel.setEmailId(resultSet.getString("email_id"));
		employeeModel.setSkypeId(resultSet.getString("skype_id"));
		employeeModel.setProfilePicture(resultSet.getString("profile_picture"));
		employeeModel.setPassword(resultSet.getString("password"));
		employeeModel.setEnabled(resultSet.getBoolean("enabled"));
		return employeeModel;
	}
}
