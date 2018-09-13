package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.response.EmployeeForgotPassword;

public class EmployeeForgotPasswordMapper implements RowMapper<EmployeeForgotPassword> {

	@Override
	public EmployeeForgotPassword mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeForgotPassword employee = new EmployeeForgotPassword();
		employee.setEmail(resultSet.getString("email_id"));
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setToken(resultSet.getString("token"));
		return employee;
	}

}
