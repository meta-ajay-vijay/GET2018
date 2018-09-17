package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.model.EmployeeAndJobDetails;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.JobDetails;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<EmployeeModel> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public boolean toggleActivation() {
		return false;
	}

	@Override
	public boolean createEmployee(EmployeeAndJobDetails employeeAndJobDetails) {
		EmployeeModel employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		System.out.println("emp:"+employeeModel.getEmpCode());
		return employeeDAO.createEmployee(employeeModel);
	}

	@Override
	public String getGeneratedEmployeeCode() {
		String lastEmpCode = employeeDAO.getLastAddedEmployee().getEmpCode();
		String newGeneratedCode = "";
		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
		NumberFormat nf = new DecimalFormat("0000");

		if (lastEmpCode == null || "".equals(lastEmpCode)) {
			newGeneratedCode = "E" + year + "/" + nf.format(0);
		} else {
			int integerCode = Integer.parseInt(lastEmpCode.split("/")[1]);
			newGeneratedCode = "E" + year + "/" + nf.format(integerCode + 1);
		}

		return newGeneratedCode;

	}

	@Override
	public List<EmployeeModel> getTeamLeaders() {
		
		return employeeDAO.getTeamLeaders();
	}

	@Override
	public List<EmployeeModel> getManagers() {
		return employeeDAO.getManagers();
	}

	@Override
	public boolean addJobDetails(EmployeeAndJobDetails employeeAndJobDetails) {
		JobDetails jobDetails = getJobDetailObject(employeeAndJobDetails);
		System.out.println("job:"+jobDetails.getEmpCode());
		return employeeDAO.addJobDetails(jobDetails);
	}

	@Override
	public EmployeeModel getEmployeeById(EmployeeAndJobDetails employeeAndJobDetails) {
		EmployeeModel employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		EmployeeModel employeeInDatabase = employeeDAO.getEmployeeById(employeeModel);
		boolean validateEmployeeFlag = false;
		if (employeeInDatabase != null) {
			if ((employeeAndJobDetails.getEmpCode().equals(employeeInDatabase.getEmpCode()))
					&& (employeeAndJobDetails.getPassword().equals(employeeInDatabase.getPassword()))) {
				validateEmployeeFlag = true;
			}
		}
		System.out.println("passwor:" + validateEmployeeFlag);

		if (validateEmployeeFlag) {
			return employeeInDatabase;
		} else {
			return null;
		}
	}

	@Override
	public EmployeeModel getEmployeeByIdString(String empCode) {
		EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
		
		employeeAndJobDetails.setEmpCode(empCode);
		EmployeeModel employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		
		return employeeDAO.getEmployeeById(employeeModel);
	}
	
	
	private EmployeeModel getEmployeeObjectByTransferObject(
			EmployeeAndJobDetails employeeAndJobDetails) {
		EmployeeModel employee = new EmployeeModel();

		employee.setDob(employeeAndJobDetails.getDob());
		employee.setEmailId(employeeAndJobDetails.getEmailId());
		employee.setEmpCode(employeeAndJobDetails.getEmpCode());
		employee.setEnabled(employeeAndJobDetails.isEnabled());
		employee.setFirstName(employeeAndJobDetails.getFirstName());
		employee.setGender(employeeAndJobDetails.getGender());
		employee.setLastName(employeeAndJobDetails.getLastName());
		employee.setPassword(employeeAndJobDetails.getPassword());
		employee.setPrimaryContactNumber(employeeAndJobDetails
				.getPrimaryContactNumber());
		employee.setProfilePicture(employeeAndJobDetails.getProfilePicture());
		employee.setSecondaryContactNumber(employeeAndJobDetails
				.getSecondaryContactNumber());
		employee.setSkypeId(employeeAndJobDetails.getEmailId());

		return employee;

	}
	
	private JobDetails getJobDetailObject(EmployeeAndJobDetails employeeAndJobDetails){
		JobDetails jobDetails = new JobDetails();
		jobDetails.setCurrentProjectId(jobDetails.getCurrentProjectId());
		jobDetails.setEmpCode(employeeAndJobDetails.getEmpCode());
		jobDetails.setJobCode(Integer.parseInt(employeeAndJobDetails.getJobTitle()));
		jobDetails.setReportingManager(employeeAndJobDetails.getManager());
		jobDetails.setTeamLead(employeeAndJobDetails.getTeamLeader());
		return jobDetails;
	}

}