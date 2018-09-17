package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;
import com.metacube.training.transferObjects.EmployeeForgotPassword;

public class EmployeeTokenMapper implements RowMapper<EmployeeForgotPassword> {

	@Override
	public EmployeeForgotPassword mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeForgotPassword employee = new EmployeeForgotPassword();
		employee.setEmail(resultSet.getString("email"));
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setToken(resultSet.getString("token"));
		return employee;
	}

}
