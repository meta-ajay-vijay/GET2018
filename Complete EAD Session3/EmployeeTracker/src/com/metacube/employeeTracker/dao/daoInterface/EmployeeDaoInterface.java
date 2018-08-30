package com.metacube.employeeTracker.dao.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.metacube.employeeTracker.Response.BooleanAndString;
import com.metacube.employeeTracker.model.Employee;

public interface EmployeeDaoInterface {
	
	public BooleanAndString addEmployee(Employee employee);
	
	public List<Employee> showEmployees() throws Exception;
	
	public void updateEmployee(Employee employee) throws Exception;
	
	public List<Employee> getEmployees(String[] name) throws SQLException;
}
