package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.mappers.EmployeeCodeAndPasswordMapper;
import com.metacube.training.mappers.EmployeeForgotPasswordMapper;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.EmployeeTeamLeadMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeCodeAndPassword;
import com.metacube.training.response.EmployeeForgotPassword;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String GET_LAST_EMPLOYEE = "SELECT * from employee ORDER BY emp_code DESC LIMIT 1;";

	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(emp_Code, first_Name, last_Name, dob, gender," + "email_Id, token) values(?,?,?,?,?,?,?)";

	private final String GET_TEAM_LEADER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_id WHERE job_title = 'Team Leader'";
	private final String GET_REPORTING_MANAGER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_id WHERE job_title = 'Manager'; ";
	private final String SQL_JOB_DETAILS = "insert into job_details (emp_code,job_code,reproting_mgr,team_lead,curr_proj_id) values (?,?,?,?,?)";
	private final String SQL_JOB_DETAILS_FOR_MANAGER = "insert into job_details (emp_code,job_code,curr_proj_id) values (?,?,?)";
	private final String SQL_JOB_DETAILS_FOR_TL = "insert into job_details (emp_code,job_code,reproting_mgr,curr_proj_id) values (?,?,?,?)";
	private final String SQL_GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE emp_code = ?";
	private final String SQL_GET_EMPLOYEE_BY_TOKEN = "SELECT * FROM employee WHERE token = ?";
	private final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE emp_code = ?";
	private final String SQL_GET_ALL = "SELECT * FROM employee WHERE enabled = ?";
	private final String SQL_ACTIVATE_EMPLOYEE = "UPDATE employee SET enabled = ?, token = ? WHERE emp_code = ?";
	private final String SQL_GET_ADMIN_BY_ID = "SELECT e.emp_code,e.password FROM employee e LEFT JOIN job_details jd ON e.emp_code=jd.emp_code LEFT JOIN job_title_master jtm ON jd.job_code=jtm.job_id WHERE jtm.job_title='admin' AND e.emp_code = ?";
	private final String GET_EMPLOYEE_BY_EMAIL = "SELECT emp_code,first_name,last_name,dob,gender,primary_contact_number,secondary_contact_number,email_id,skype_id,password,enabled,profile_picture,token FROM employee WHERE email_id = ?";
	private final String INSERT_EMPLOYEE_FORGOT_TABLE = "UPDATE employee SET token=? WHERE emp_code=?";
	private final String GET_EMPLOYEE_BY_TOKEN = "select emp_code,email_id,token from employee where token = ?";
	private final String UPDATE_EMPLOYEE_PASSWORD = "UPDATE employee SET password = ? WHERE emp_code = ?";
	private final String DELETE_EMPLOYEE_TOKEN = "UPDATE employee SET token=? where token = ?";
	private final String UPDATE_EMPLOYEE = "UPDATE employee SET first_name=?,last_name=?,dob=?,primary_contact_number=?,secondary_contact_number=?,email_id=?,skype_id=? WHERE emp_code = ?";

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query(SQL_GET_ALL, new Object[] { true }, new EmployeeMapper());
	}

	@Override
	public boolean toggleActivation() {
		return false;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getEmpCode(), employee.getFirstName(),
				employee.getLastName(), employee.getDob(), employee.getGender(), employee.getEmailId(),
				employee.getToken()) > 0;
	}

	@Override
	public Employee getLastAddedEmployee() {
		// return jdbcTemplate.queryForObject(GET_LAST_EMPLOYEE, new
		// EmployeeMapper());
		Employee employee;
		List<Employee> list = jdbcTemplate.query(GET_LAST_EMPLOYEE, new EmployeeMapper());
		if (list.size() > 0) {
			employee = list.get(0);
		} else {
			employee = new Employee();
		}
		return employee;
	}

	@Override
	public List<Employee> getTeamLeaders() {
		return jdbcTemplate.query(GET_TEAM_LEADER, new EmployeeTeamLeadMapper());
	}

	@Override
	public List<Employee> getManagers() {
		return jdbcTemplate.query(GET_REPORTING_MANAGER, new EmployeeTeamLeadMapper());
	}

	@Override
	public boolean addJobDetails(Employee employee) {
		boolean result;
		if (employee.getManager() == null || "".equals(employee.getManager())) {
			result = jdbcTemplate.update(SQL_JOB_DETAILS_FOR_MANAGER, employee.getEmpCode(), employee.getJobTitle(),
					employee.getProjectTitle()) > 0;
		} else if ((employee.getManager() != null || !"".equals(employee.getManager()))
				&& (employee.getTeamLeader() == null || "".equals(employee.getTeamLeader()))) {
			result = jdbcTemplate.update(SQL_JOB_DETAILS_FOR_TL, employee.getEmpCode(), employee.getJobTitle(),
					employee.getManager(), employee.getProjectTitle()) > 0;
		} else {
			result = jdbcTemplate.update(SQL_JOB_DETAILS, employee.getEmpCode(), employee.getJobTitle(),
					employee.getManager(), employee.getTeamLeader(), employee.getProjectTitle()) > 0;
		}
		return result;
	}

	@Override
	public Employee getEmployeeById(Employee employee) {
		return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEE_BY_ID, new Object[] { employee.getEmpCode() },
				new EmployeeMapper());
	}

	@Override
	public EmployeeCodeAndPassword getAdminById(Employee employee) {
		return jdbcTemplate.queryForObject(SQL_GET_ADMIN_BY_ID, new Object[] { employee.getEmpCode() },
				new EmployeeCodeAndPasswordMapper());
	}

	@Override
	public Employee findUserByEmail(String employeeEmail) {
		Employee object = null;
		List<Employee> employees = jdbcTemplate.query(GET_EMPLOYEE_BY_EMAIL, new Object[] { employeeEmail },
				new EmployeeMapper());
		if (employees.size() > 0) {
			object = employees.get(0);
		}
		return object;
	}

	@Override
	public boolean deleteEmployee(String id) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, id) > 0;
	}

	@Override
	public Employee getEmployeeByToken(String token) {
		List<Employee> listOfmployee = jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_TOKEN, new Object[] { token },
				new EmployeeMapper());
		Employee employee;
		if (listOfmployee.size() > 0) {
			employee = listOfmployee.get(0);
		} else {
			employee = null;
		}
		return employee;
	}

	@Override
	public void activateEmployeeByEmployeeCodeAndRemoveToken(String empCode) {
		jdbcTemplate.update(SQL_ACTIVATE_EMPLOYEE, new Object[] { true, null, empCode });
	}

	// These are for Forgot password.
	@Override
	public boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword) {
		return (jdbcTemplate.update(INSERT_EMPLOYEE_FORGOT_TABLE, employeeForgotPassword.getToken(),
				employeeForgotPassword.getEmpCode()) > 0);
	}

	@Override
	public EmployeeForgotPassword findUserByResetToken(String token) {
		List<EmployeeForgotPassword> resultList = jdbcTemplate.query(GET_EMPLOYEE_BY_TOKEN, new Object[] { token },
				new EmployeeForgotPasswordMapper());
		EmployeeForgotPassword employeeForgotPassword;
		if (resultList.size() > 0) {
			employeeForgotPassword = resultList.get(0);
		} else {
			employeeForgotPassword = null;
		}
		return employeeForgotPassword;
	}

	@Override
	public boolean updateEmployeePassword(Employee employee) {
		return (jdbcTemplate.update(UPDATE_EMPLOYEE_PASSWORD, employee.getPassword(), employee.getEmpCode()) > 0);
	}

	@Override
	public boolean deleteToken(String token) {
		return (jdbcTemplate.update(DELETE_EMPLOYEE_TOKEN, null, token) > 0);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return (jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getDob(),
				employee.getPrimaryContactNumber(), employee.getSecondaryContactNumber(), employee.getEmailId(),
				employee.getSkypeId(), employee.getEmpCode()) > 0);
	}
}
