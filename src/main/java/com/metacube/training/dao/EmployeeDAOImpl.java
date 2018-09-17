package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.daointerfaces.EmployeeDAO;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.EmployeeTeamLeaderMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;


@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	private SessionFactory sessionFactory;
*/	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_ALL = "select * from employees";
	private final String SQL_GET_LAST_ID = "select * from employees order by emp_code desc limit 1";
	private final String SQL_INSERT_EMPLOYEE = "insert into employees(emp_code,first_name,last_name,dob,doj,gender,primary_contact_number,email_id,password) Values (?,?,?,?,?,?,?,?,?)";
	private final String SQL_ENABLE = "update employees SET enabled = true Where emp_code = ?";	
	private final String SQL_DISABLE = "update employees SET enabled = false Where emp_code = ?";
	private final String SQL_JOB_DETAILS = "insert into job_details (emp_code,job_code,reporting_mgr,team_lead,curr_proj_id) values (?,?,?,?,?)";
	private final String SQL_GET_EMPLOYEE_BY_ID = "select * from employees where emp_code=?";
	private final String GET_TEAM_LEADER = "select employees.emp_code,first_name from employees LEFT JOIN job_details ON employees.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_code WHERE job_title = 'team lead'";
	private final String GET_REPORTING_MANAGER = "select employees.emp_code,first_name from employees LEFT JOIN job_details ON employees.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_code WHERE job_title = 'manager'";
	private final String GET_EMPLOYEE_BY_EMAIL = "select * from employees where email_id = ?";
	private final String UPDATE_EMPLOYEE_PASSWORD = "update employees set password = ? where emp_code = ?";
	
	//These are for forgot password.
	private final String INSERT_EMPLOYEE_FORGOT_TABLE = "insert into employee_token_fp (emp_code,email,token) values (?,?,?)";
	private final String GET_EMPLOYEE_BY_TOKEN = "select * from employee_token_fp where token = ?";
	private final String DELETE_EMPLOYEE_TOKEN = "delete from employee_token_fp where token = ?";

	@Override
	public Employee getEmployeeById(String empCode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeTransferObject> getAllEmployeeTransferObjects() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean disableEmployee(String empCode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean enableEmployee(String empCode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean createEmployee(EmployeeTransferObjectWithJobDetails employee) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getLastEmployeeCode() {
		List<Employee> employee = jdbcTemplate.query(SQL_GET_LAST_ID, new EmployeeMapper());
		if(employee.size()>0)
		{
			return employee.get(0).getEmpCode();
		}
		return null;
	}
	@Override
	public boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Employee> getTeamLeaders() {
		return jdbcTemplate.query(GET_TEAM_LEADER,new EmployeeTeamLeaderMapper());
	}
	@Override
	public List<Employee> getManagers() {
		return jdbcTemplate.query(GET_REPORTING_MANAGER,new EmployeeTeamLeaderMapper());
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
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	/*@Override
	public Employee getEmployeeById(String empCode) {
		List<Employee> resultList = jdbcTemplate.query(SQL_GET_EMPLOYEE_BY_ID, new Object[] { empCode },new EmployeeMapper());
		String hql = "FROM Employee Where emp_code = :id";
		Query<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", empCode);
		List<Employee> resultsList = query.list();
		if(resultsList.size()>0)
		{
			return resultsList.get(0);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = (CriteriaQuery<Employee>) builder.createQuery(Employee.class);
		Root<Employee> employeeRoot =  criteria.from(Employee.class);
		criteria.select(employeeRoot);
		List<Employee> employees = session.createQuery(criteria).getResultList();
		session.close();
		return employees;
		//return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	@Override
	public List<EmployeeTransferObject> getAllEmployeeTransferObjects() {
		return null;
	}

	@Override
	public boolean disableEmployee(String empCode) {
		// TODO Auto-generated method stub
		String hql = "UPDATE Employee set enabled = :value WHERE emp_code = :empCode";
		Query<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("empCode", empCode);
		query.setParameter("value", false);
		int result = query.executeUpdate();
		return result > 0;
		//return ((jdbcTemplate.update(SQL_DISABLE,empCode))>0);
	}

	@Override
	public boolean enableEmployee(String empCode) {
		//return ((jdbcTemplate.update(SQL_ENABLE,empCode))>0);
		String hql = "UPDATE Employee set enabled = :value WHERE emp_code = :empCode";
		Query<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("empCode", empCode);
		query.setParameter("value", true);
		int result = query.executeUpdate();
		return result > 0;
	}

	@Override
	public boolean createEmployee(EmployeeTransferObjectWithJobDetails employeeTransferObject) {
		Employee employee = new Employee(employeeTransferObject);
		sessionFactory.getCurrentSession().save(employee);
		return true;
		//return 	 jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getEmpCode(),employee.getFirstName(),employee.getLastName(),employee.getDob(),employee.getDateOfJoining(),employee.getGender(),employee.getContactNumber(),employee.getEmailId(),employee.getPassword()) > 0;
	}

	@Override
	public String getLastEmployeeCode(){
		List<Employee> employee = jdbcTemplate.query(SQL_GET_LAST_ID, new EmployeeMapper());
		return employee.get(0).getEmpCode();
		String hql = "FROM Employee Order By empCode Desc";
		Query<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Employee> results = query.list();
		if(results.size()>0)
		{
			return  results.get(0).getEmpCode();
		}
		return null;
	}

	@Override
	public boolean createJobDetails(EmployeeTransferObjectWithJobDetails employee) {
		JobDetails jobDetails = new JobDetails(employee);
		sessionFactory.getCurrentSession().save(jobDetails);
		return true;
		//return (jdbcTemplate.update(SQL_JOB_DETAILS, employee.getEmpCode(),employee.getJobCode(),employee.getReportingManager(),employee.getTeamLead(),employee.getProjectId()))>0;
	}
	
	@Override
	public List<Employee> getTeamLeaders(){
		//String hql = "select employees.emp_code,first_name from employees LEFT JOIN job_details ON employees.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_code WHERE job_title = 'team lead' ";
		//FROM Employee Left Join JobDetails On Employee.empCode = JobDetails.empCode Left Join Job On Job.id = JobDetails.jobCode Where Job.name = 'team lead'";
		//select employees.emp_code,first_name from employees LEFT JOIN job_details ON employees.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_code WHERE job_title = 'team lead'
		Query<Employee> query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Employee> results = query.list();
		return results;
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> query = session.getCriteriaBuilder().createQuery(Employee.class);
		Root<Job> jobroot = query.from(Job.class);
		Root<JobDetails> jobDetailsroot = query.from(JobDetails.class);
		Root<Employee> employeeroot = query.from(Employee.class);
		query.select(employeeroot).where(builder.equal(employeeroot.get("empCode"),jobDetailsroot.get("empCode")),
				builder.equal(jobDetailsroot.get("jobCode"),jobroot.get("id")),
				builder.equal(jobroot.get("name"),"team lead"));
		List<Employee> l = session.createQuery(query).getResultList();
		return l;
		//	Session session = sessionFactory.getCurrentSession();
		//	CriteriaBuilder builder = session.getCriteriaBuilder();
		//	CriteriaQuery<Skill> query = session.getCriteriaBuilder().createQuery(Skill.class);
		//	Root<EmployeeSkill> employeeSkillRoot = query.from(EmployeeSkill.class);
		//	Root<Skill> skillRoot = query.from(Skill.class);
		//	query.select(skillRoot).where(
		//	builder.equal(employeeSkillRoot.get("employeeId"), employeeId),
		//	builder.equal(employeeSkillRoot.get("skillId"), skillRoot.get("id")));
		//	return session.createQuery(query).getResultList();
			
		
		//return jdbcTemplate.query(GET_TEAM_LEADER,new EmployeeTeamLeaderMapper());
	}
	
	@Override
	public List<Employee> getManagers(){
		//return jdbcTemplate.query(GET_REPORTING_MANAGER,new EmployeeTeamLeaderMapper());
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> query = session.getCriteriaBuilder().createQuery(Employee.class);
		Root<Job> jobroot = query.from(Job.class);
		Root<JobDetails> jobDetailsroot = query.from(JobDetails.class);
		Root<Employee> employeeroot = query.from(Employee.class);
		query.select(employeeroot).where(builder.equal(employeeroot.get("empCode"),jobDetailsroot.get("empCode")),
				builder.equal(jobDetailsroot.get("jobCode"),jobroot.get("id")),
				builder.equal(jobroot.get("name"),"manager"));
		List<Employee> l = session.createQuery(query).getResultList();
		return l;
	}

	@Override
	public Employee findUserByEmail(String employeeEmail) {
		Employee object = null;
		List<Employee> employees =  jdbcTemplate.query(GET_EMPLOYEE_BY_EMAIL, new Object[] { employeeEmail },new EmployeeMapper());
		if(employees.size()>0)
			{
			 	object = employees.get(0);
			}
		return object;
	}
	
	@Override
	public boolean updateEmployee(Employee employee) {
		return (jdbcTemplate.update(UPDATE_EMPLOYEE_PASSWORD,employee.getPassword(),employee.getEmpCode())>0);
	}

	
	//These are for Forgot password.
	@Override
	public boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword) {
		return (jdbcTemplate.update(INSERT_EMPLOYEE_FORGOT_TABLE,employeeForgotPassword.getEmpCode(),employeeForgotPassword.getEmail(),employeeForgotPassword.getToken())>0);
	}

	@Override
	public EmployeeForgotPassword findUserByResetToken(String token) {
		List<EmployeeForgotPassword> resultList = jdbcTemplate.query(GET_EMPLOYEE_BY_TOKEN,new Object[] {token}, new EmployeeTokenMapper());
		if(resultList.size()>0)
		{
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public boolean deleteToken(String token) {
		return (jdbcTemplate.update(DELETE_EMPLOYEE_TOKEN,token)>0);
	}
*/
}
