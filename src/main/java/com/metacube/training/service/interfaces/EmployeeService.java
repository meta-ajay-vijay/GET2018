package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeCodeAndPassword;
import com.metacube.training.response.EmployeeForgotPassword;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	boolean toggleActivation();
	boolean createEmployee(Employee employee);
	public List<Employee> getTeamLeaders();
	public List<Employee> getManagers();
	boolean addJobDetails(Employee employee);
	Employee getEmployeeById(Employee employee);
	Employee getEmployeeByIdString(String empCode);
	boolean deleteEmployee(String id);
	Employee getEmployeeByToken(String token);
	void activateEmployeeByEmployeeCodeAndRemoveToken(String empCode);
	EmployeeCodeAndPassword getAdminById(Employee employee);
	Employee findUserByEmail(String employeeEmail);
	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);
	EmployeeForgotPassword findUserByResetToken(String token);
	boolean updateEmployee(Employee employee);
	boolean deleteToken(String resetToken);
	boolean updateEmployeePassword(Employee employee);

}
