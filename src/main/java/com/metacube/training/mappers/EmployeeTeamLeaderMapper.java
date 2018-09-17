package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeTeamLeaderMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		return employee;
		}

	

		}
