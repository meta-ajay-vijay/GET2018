package com.metacube.training.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.EmployeeTeamLeadMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String GET_LAST_EMPLOYEE = "SELECT *from employee ORDER BY emp_code DESC LIMIT 1;";

	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(emp_Code, first_Name, last_Name, dob, gender,"
			+ "email_Id) values(?,?,?,?,?,?)";
	
	private final String GET_TEAM_LEADER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_id WHERE job_title = 'Team Leader'"; 
	private final String GET_REPORTING_MANAGER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_id WHERE job_title = 'Manager'; "; 
    private final String SQL_JOB_DETAILS = "insert into job_details (emp_code,job_code,reproting_mgr,team_lead,curr_proj_id) values (?,?,?,?,?)";
    
    private final String SQL_GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE emp_code = ?"; 
    
	
    @Override
	public List<Employee> getAllEmployee() {
		
		return null;
	}

	@Override
	public boolean toggleActivation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
				employee.getEmpCode(), employee.getFirstName(),
				employee.getLastName(), employee.getDob(),
				employee.getGender(), employee.getEmailId()) > 0;
	}

	@Override
	public Employee getLastAddedEmployee() {
		return jdbcTemplate.queryForObject(GET_LAST_EMPLOYEE, new EmployeeMapper());
	}

	@Override
	public List<Employee> getTeamLeaders() {
		return jdbcTemplate.query(GET_TEAM_LEADER,new EmployeeTeamLeadMapper());
	}

	@Override
	public List<Employee> getManagers() {
		
		return jdbcTemplate.query(GET_REPORTING_MANAGER,new EmployeeTeamLeadMapper());

	}
	
	@Override
	public boolean addJobDetails(Employee employee) {

		return jdbcTemplate.update(SQL_JOB_DETAILS, employee.getEmpCode(),
				employee.getJobTitle(), employee.getManager(),
				employee.getTeamLeader(), employee.getProjectTitle()) > 0 ;
	}	
	
	@Override
	public Employee getEmployeeById(Employee employee){
		return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEE_BY_ID, new Object[]{employee.getEmpCode()},new EmployeeMapper());
	}
	

}
