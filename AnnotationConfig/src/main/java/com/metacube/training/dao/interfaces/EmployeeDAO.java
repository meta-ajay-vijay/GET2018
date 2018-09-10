package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployee();
	boolean toggleActivation();
	boolean createEmployee(Employee employee);
	Employee getLastAddedEmployee();
	List<Employee> getTeamLeaders();
	List<Employee> getManagers();
	boolean addJobDetails(Employee employee);
	Employee getEmployeeById(Employee employee);
	
}
