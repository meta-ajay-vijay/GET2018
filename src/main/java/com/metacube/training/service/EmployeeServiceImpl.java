package com.metacube.training.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeAndJobDetails;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.JobTitleRepository;
import com.metacube.training.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private JobDetailsRepository JobDetailsRepository;
	
	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean toggleActivation() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean createEmployee(EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		employeeRepository.save(employeeModel);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getGeneratedEmployeeCode() {
		List<Employee> listOfAllEmployee = employeeRepository.getLastEmployeeAdded();
		String lastEmpCode = listOfAllEmployee.get(0).getEmpCode();
		
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

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	@Override
	public List<Employee> getTeamLeaders() {
		
		JobTitle jobTitle = jobTitleRepository.getJobTitleByJobTitle("Team Leader");
		Hibernate.initialize(jobTitle.getEmployees());
		return jobTitle.getEmployees();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	@Override
	public List<Employee> getManagers() {
		JobTitle jobTitle = jobTitleRepository.getJobTitleByJobTitle("Manager");
		Hibernate.initialize(jobTitle.getEmployees());
		return jobTitle.getEmployees();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addJobDetails(EmployeeAndJobDetails employeeAndJobDetails) {
		JobDetails jobDetails = getJobDetailObject(employeeAndJobDetails);
		JobDetailsRepository.save(jobDetails);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeById(EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
		Employee employeeInDatabase = (Employee) employeeRepository.findOne(employeeModel.getEmpCode());
		boolean validateEmployeeFlag = false;
		if (employeeInDatabase != null) {
			if ((employeeAndJobDetails.getEmpCode().equals(employeeInDatabase.getEmpCode()))
					&& (employeeAndJobDetails.getPassword().equals(employeeInDatabase.getPassword()))) {
				validateEmployeeFlag = true;
			}
		}
		System.out.println("password:" + validateEmployeeFlag);

		if (validateEmployeeFlag) {
			return employeeInDatabase;
		} else {
			return null;
		}
	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public Employee getEmployeeByIdString(String empCode) {
		EmployeeAndJobDetails employeeAndJobDetails = new EmployeeAndJobDetails();
		
		employeeAndJobDetails.setEmpCode(empCode);
		Employee employeeModel = getEmployeeObjectByTransferObject(employeeAndJobDetails);
 
		return (Employee) employeeRepository.findOne(empCode);
	}
	
	
	private Employee getEmployeeObjectByTransferObject(
			EmployeeAndJobDetails employeeAndJobDetails) {
		Employee employee = new Employee();

		employee.setDob(employeeAndJobDetails.getDob());
		employee.setEmailId(employeeAndJobDetails.getEmailId());
		employee.setEmpCode(employeeAndJobDetails.getEmpCode());
		employee.setEnabled(employeeAndJobDetails.isEnabled());
		employee.setFirstName(employeeAndJobDetails.getFirstName());
		employee.setGender(employeeAndJobDetails.getGender());
		employee.setLastName(employeeAndJobDetails.getLastName());
		employee.setPassword(employeeAndJobDetails.getPassword());
		employee.setPrimaryContactNumber(employeeAndJobDetails.getPrimaryContactNumber());
		employee.setProfilePicture(employeeAndJobDetails.getProfilePicture());
		employee.setSecondaryContactNumber(employeeAndJobDetails.getSecondaryContactNumber());
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

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmployee(Employee employee) {
		Employee employeeToUpdate = getEmployeeByIdString(employee.getEmpCode());
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setEmailId(employee.getEmailId());
		employeeToUpdate.setPrimaryContactNumber(employee.getPrimaryContactNumber());
		employeeRepository.save(employeeToUpdate);
		return true;
	}
}

