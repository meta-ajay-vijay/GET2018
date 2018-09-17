package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
/*	private JdbcTemplate jdbcTemplate;
*/	
	@Autowired
	SessionFactory sessionFactory;

/*	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/

	//private final String GET_LAST_EMPLOYEE = "SELECT *from employee ORDER BY emp_code DESC LIMIT 1;";

/*	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(emp_Code, first_Name, last_Name, dob, gender,"
			+ "email_Id) values(?,?,?,?,?,?)";
*/
	//private final String GET_TEAM_LEADER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_code= job_title_master.job_id WHERE job_title = 'Team Leader'";
	//private final String GET_REPORTING_MANAGER = "select employee.emp_code,first_name from employee LEFT JOIN job_details ON employee.emp_code = job_details.emp_code LEFT JOIN job_title_master ON job_details.job_id= job_title_master.job_id WHERE job_title = 'Manager'; ";
	//private final String SQL_JOB_DETAILS = "insert into job_details (emp_code,job_code,reproting_mgr,team_lead,curr_proj_id) values (?,?,?,?,?)";

	private final String SQL_GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE emp_code = ?";

	@Override
	public List<EmployeeModel> getAllEmployee(){
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<EmployeeModel> criteria = builder.createQuery(EmployeeModel.class);
        Root<EmployeeModel> employeeRoot = criteria.from(EmployeeModel.class);
        criteria.select(employeeRoot);
		
        List<EmployeeModel> employees = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return employees;
	}

	@Override
	public boolean toggleActivation() {
		return false;
	}

	@Override
	public boolean createEmployee(EmployeeModel employeeModel){
		/*
		 * return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
		 * employeeAndJobDetails.getEmpCode(),
		 * employeeAndJobDetails.getFirstName(),
		 * employeeAndJobDetails.getLastName(), employeeAndJobDetails.getDob(),
		 * employeeAndJobDetails.getGender(),
		 * employeeAndJobDetails.getEmailId()) > 0;
		 */
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.save(employeeModel);
			transaction.commit();
					
		}catch(HibernateException e){
			if(transaction !=null){
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
		return true;

	}

	@Override
	public EmployeeModel getLastAddedEmployee(){

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeModel.class);
		criteria.addOrder(Order.desc("empCode"));
		criteria.setMaxResults(1);
		return (EmployeeModel) criteria.uniqueResult();
	}

	@Override
	public List<EmployeeModel> getTeamLeaders() {
/*		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeModel> query = session.getCriteriaBuilder().createQuery(EmployeeModel.class);
		Root<JobTitle> jobroot = query.from(JobTitle.class);
		Root<JobDetails> jobDetailsroot = query.from(JobDetails.class);
		Root<EmployeeModel> employeeroot = query.from(EmployeeModel.class);
		query.select(employeeroot).where(builder.equal(employeeroot.get("empCode"),jobDetailsroot.get("empCode")),
		builder.equal(jobDetailsroot.get("jobCode"),jobroot.get("id")),
		builder.equal(jobroot.get("jobTitle"),"Team Leader"));
		return session.createQuery(query).getResultList();
*/	
/*		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeModel> query = session.getCriteriaBuilder().createQuery(EmployeeModel.class);
		
		Root<EmployeeModel> employeeRoot = query.from(EmployeeModel.class);
		
		query.select(employeeRoot).where(builder.equal(employeeRoot.get("jobs"), "Team Leader"));
		
		return session.createQuery(query).getResultList();
*/
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobTitle> query = session.getCriteriaBuilder().createQuery(JobTitle.class);
		
		Root<JobTitle> jobroot = query.from(JobTitle.class);
		
		query.select(jobroot).where(builder.equal(jobroot.get("jobTitle"), "Team Leader"));
		
		return session.createQuery(query).getResultList().get(0).getTeamLeaders();
	}

	@Override
	public List<EmployeeModel> getManagers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobTitle> query = session.getCriteriaBuilder().createQuery(JobTitle.class);
		
		Root<JobTitle> jobroot = query.from(JobTitle.class);
		
		query.select(jobroot).where(builder.equal(jobroot.get("jobTitle"), "Manager"));
		
		return session.createQuery(query).getResultList().get(0).getTeamLeaders();

	}

	@Override
	public boolean addJobDetails(JobDetails jobDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.save(jobDetails);
			transaction.commit();
					
		}catch(HibernateException e){
			if(transaction !=null){
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
		return true;
	}

	@Override
	public EmployeeModel getEmployeeById(EmployeeModel employeeModel) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<EmployeeModel> criteria = builder.createQuery(EmployeeModel.class);
        Root<EmployeeModel> employeeRoot = criteria.from(EmployeeModel.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("empCode"), employeeModel.getEmpCode()));
		
        EmployeeModel employee = session.createQuery(criteria).getSingleResult();
		
		session.close();
		
		return employee;
	}


}