package com.metacube.training.dao.daointerfaces;

import java.util.List;
import java.util.Optional;

import com.metacube.training.model.Employee;

import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;


public interface EmployeeDAO {
	
	Employee getEmployeeById(String empCode);

	List<Employee> getAllEmployees();
	
	List<EmployeeTransferObject> getAllEmployeeTransferObjects();

	boolean disableEmployee(String empCode);

	boolean enableEmployee(String empCode);

	boolean createEmployee(EmployeeTransferObjectWithJobDetails employee);
	
	String getLastEmployeeCode();

	boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	List<Employee> getTeamLeaders();

	List<Employee> getManagers();

	Employee findUserByEmail(String employeeEmail);

	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);

	EmployeeForgotPassword findUserByResetToken(String token);

	boolean updateEmployee(Employee employee);

	boolean deleteToken(String token);
}
