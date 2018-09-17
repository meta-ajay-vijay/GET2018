package com.metacube.training.service.serviceinterface;

import java.util.List;

import com.metacube.training.model.Employee;

import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeSkills;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

public interface EmployeeService {
	Employee getEmployeeById(String empCode);

	List<EmployeeTransferObject> getAllEmployeeTransferObjects();
	
	List<Employee> getAllEmployees();

	boolean disableEmployee(String empCode);
	
    boolean enableEmployee(String empCode);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	List<Employee> getTeamLeaders();

	List<Employee> getManagers();

	Employee findUserByEmail(String employeeEmail);

	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);

	EmployeeForgotPassword findUserByResetToken(String token);

	boolean deleteToken(String token);

	boolean addSkills(EmployeeSkills employee);

}
