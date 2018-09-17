package com.metacube.training.dao.interfaces;

import java.util.List;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.JobDetails;

public interface EmployeeDAO {

	List<EmployeeModel> getAllEmployee();

	boolean toggleActivation();

	boolean createEmployee(EmployeeModel employeeModel);

	EmployeeModel getLastAddedEmployee();

	List<EmployeeModel> getTeamLeaders();

	List<EmployeeModel> getManagers();
	


	EmployeeModel getEmployeeById(EmployeeModel employeeModel);

	boolean addJobDetails(JobDetails jobDetails);

}