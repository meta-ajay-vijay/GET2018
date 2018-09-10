package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean toggleActivation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		employee.setEmpCode(getGeneratedEmployeeCode());
		return employeeDAO.createEmployee(employee);
	}
	
	private String getGeneratedEmployeeCode() {
		String lastEmpCode = employeeDAO.getLastAddedEmployee().getEmpCode();
		String newGeneratedCode = "";
		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
		NumberFormat nf = new DecimalFormat("0000");

		if (lastEmpCode == null || "".equals(lastEmpCode)) {
			newGeneratedCode = "E" + year + "/" + nf.format(0);
		} else {
			int integerCode = Integer.parseInt(lastEmpCode.split("/")[1]);
			newGeneratedCode = "E" + year + "/" + nf.format(integerCode+1);
		}

		return newGeneratedCode;

	}
	
	@Override
	public List<Employee> getTeamLeaders() {
		return employeeDAO.getTeamLeaders();
	}

	@Override
	public List<Employee> getManagers() {
		return employeeDAO.getManagers();
	}

	@Override
	public boolean addJobDetails(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addJobDetails(employee);
	}

	@Override
	public Employee getEmployeeById(Employee employee) {
		Employee employeeInDatabase = employeeDAO.getEmployeeById(employee);
		boolean validateEmployeeFlag = false;
		if (employeeInDatabase != null) {
			if ((employee.getEmpCode().equals(employeeInDatabase.getEmpCode()))
					&& (employee.getPassword().equals(employeeInDatabase
							.getPassword()))) {
				validateEmployeeFlag = true;
			}
		}
		System.out.println("passwor:"+validateEmployeeFlag);
		
		if(validateEmployeeFlag){
		return employeeInDatabase;
		}else{
			return null;
		}
		
	}

	@Override
	public Employee getEmployeeByIdString(String empCode) {
		Employee employee = new Employee();
		employee.setEmpCode(empCode);
		return employeeDAO.getEmployeeById(employee);
	}
	
}
