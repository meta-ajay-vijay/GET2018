package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeCodeAndPassword;

public class EmployeeCodeAndPasswordMapper implements RowMapper<EmployeeCodeAndPassword>{
	@Override
	public EmployeeCodeAndPassword mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeCodeAndPassword employee = new EmployeeCodeAndPassword();
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setPassword(resultSet.getString("password"));
		return employee;
	}
}
