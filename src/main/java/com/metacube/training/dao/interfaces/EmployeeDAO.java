package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeCodeAndPassword;
import com.metacube.training.response.EmployeeForgotPassword;

public interface EmployeeDAO {
	List<Employee> getAllEmployee();
	boolean toggleActivation();
	boolean createEmployee(Employee employee);
	Employee getLastAddedEmployee();
	List<Employee> getTeamLeaders();
	List<Employee> getManagers();
	boolean addJobDetails(Employee employee);
	Employee getEmployeeById(Employee employee);
	boolean deleteEmployee(String id);
	Employee getEmployeeByToken(String token);
	void activateEmployeeByEmployeeCodeAndRemoveToken(String empCode);
	EmployeeCodeAndPassword getAdminById(Employee employee);
	Employee findUserByEmail(String employeeEmail);
	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);
	EmployeeForgotPassword findUserByResetToken(String token);
	boolean deleteToken(String token);
	boolean updateEmployeePassword(Employee employee);
	boolean updateEmployee(Employee employee);
	
}
