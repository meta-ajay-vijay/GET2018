package com.metacube.training.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.daointerfaces.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.serviceinterface.EmployeeService;
import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeSkills;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeedao;


	@Autowired
    private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
    private SkillRepository<Skill> skillRepository;
	
	@Autowired
    private JobDetailsRepository<JobDetails> jobDetailsRepository;
	
	@Override
	public Employee getEmployeeById(String empCode) {
		return employeeRepository.findOne(empCode);
	}

	@Override
	public List<EmployeeTransferObject> getAllEmployeeTransferObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean disableEmployee(String empCode) {
		Employee employee = employeeRepository.findOne(empCode);
		if(employee!=null)
		{
			employee.setEnabled(true);
			try{
				employeeRepository.save(employee);
			}catch(Exception e)
			{
				e.printStackTrace();
				return true;
			}
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean enableEmployee(String empCode) {
		Employee employee = employeeRepository.findOne(empCode);
		if(employee!=null)
		{
			employee.setEnabled(true);
			try{
				employeeRepository.save(employee);
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try{
			employeeRepository.save(employee);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean createEmployee(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		employeeTransferObject.setEmpCode(this.getEmpCode());
		Employee employee = new Employee(employeeTransferObject);
		JobDetails jobDetails = new JobDetails(employeeTransferObject);
		try{
			employeeRepository.save(employee);
			jobDetailsRepository.save(jobDetails);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getEmpCode() {
		String lastEmployeeCode = (employeedao.getLastEmployeeCode());
		int currYear;
		if(lastEmployeeCode!=null || !(lastEmployeeCode.equals("")))
        {
			String subLastEmployeeCode[] = lastEmployeeCode.split("/");
			int year = Integer.parseInt(subLastEmployeeCode[0].substring(1));
			int code = Integer.parseInt(subLastEmployeeCode[1].substring(1));
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			int currentYear = c.get(Calendar.YEAR);
			currYear = currentYear;
			if(currentYear!=year)
			{
				return ("E"+currentYear+"/C1000");
			}
			else
			{
				return ("E"+year+"/C"+(code+1));
			}
        }
		return null;
	}

	@Override
	public boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		JobDetails jobDetails = new JobDetails(employeeTransferObject);
	   jobDetailsRepository.save(jobDetails);
	   return true;
	}

	@Override
	public List<Employee> getTeamLeaders() {
		
		return employeedao.getTeamLeaders();
	}

	@Override
	public List<Employee> getManagers() {
		// TODO Auto-generated method stub
		return employeedao.getManagers();
	}

	@Override
	public Employee findUserByEmail(String employeeEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeForgotPassword findUserByResetToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSkills(EmployeeSkills employee) {
		Employee newEmployee = employeeRepository.findOne(employee.getEmpCode());
		List<Skill> skillSet=  skillRepository.findAll();
		Set<Skill>skillSet2 = new HashSet<Skill>(skillSet);
		newEmployee.setSkills(skillSet2);
		employeeRepository.save(newEmployee);
		return false;
	}
	
	
}
