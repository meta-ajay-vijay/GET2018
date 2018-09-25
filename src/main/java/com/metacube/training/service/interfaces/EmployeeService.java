package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeAndJobDetails;

public interface EmployeeService {
	List<Employee> getAllEmployee();

	boolean toggleActivation();

	boolean createEmployee(EmployeeAndJobDetails employeeAndJobDetails);

	public List<Employee> getTeamLeaders();

	public List<Employee> getManagers();

	boolean addJobDetails(EmployeeAndJobDetails employeeAndJobDetails);

	Employee getEmployeeById(EmployeeAndJobDetails employeeAndJobDetails);

	Employee getEmployeeByIdString(String empCode);

	String getGeneratedEmployeeCode();
	
	boolean updateEmployee(Employee employee);

}
