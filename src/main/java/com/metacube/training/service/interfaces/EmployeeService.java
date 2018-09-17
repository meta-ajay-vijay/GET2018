package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.EmployeeAndJobDetails;
import com.metacube.training.model.EmployeeModel;

public interface EmployeeService {
	List<EmployeeModel> getAllEmployee();

	boolean toggleActivation();

	boolean createEmployee(EmployeeAndJobDetails employeeAndJobDetails);

	public List<EmployeeModel> getTeamLeaders();

	public List<EmployeeModel> getManagers();

	boolean addJobDetails(EmployeeAndJobDetails employeeAndJobDetails);

	EmployeeModel getEmployeeById(EmployeeAndJobDetails employeeAndJobDetails);

	EmployeeModel getEmployeeByIdString(String empCode);

	String getGeneratedEmployeeCode();

}