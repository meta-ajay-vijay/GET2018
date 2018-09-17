package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.JobTitleDAO;
import com.metacube.training.mappers.JobTitleMapper;
import com.metacube.training.model.JobTitle;

@Repository
public class JobTitleDAOImpl implements JobTitleDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public JobTitleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_DELETE_JOB_TITLE = "delete from job_title_master where job_id = ?";
	private final String SQL_UPDATE_JOB_TITLE = "update job_title_master set job_title = ? where job_id = ?";
	private final String SQL_GET_ALL = "select * from job_title_master";
	private final String SQL_INSERT_JOB_TITLE = "insert into job_title_master(job_title) values(?)";
	private final String SQL_GET_JOB_BY_ID = "SELECT *FROM job_title_master WHERE job_id = ? ";

	@Override
	public List<JobTitle> getAllJobTitle() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<JobTitle> criteriaQuery = criteriaBuilder.createQuery(JobTitle.class);
		Root<JobTitle> jobTitleRoot = criteriaQuery.from(JobTitle.class);
		criteriaQuery.select(jobTitleRoot);
		List<JobTitle> listOfJobTitles = session.createQuery(criteriaQuery).getResultList();
		session.close();
		return listOfJobTitles;
	}

	@Override
	public boolean deleteJobTitle(int id) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
		CriteriaDelete<JobTitle> deleteCriteria = criteriaBuilder.createCriteriaDelete(JobTitle.class);
        Root<JobTitle> jobTitleRoot = deleteCriteria.from(JobTitle.class);
        deleteCriteria.where(criteriaBuilder.equal(jobTitleRoot.get("job_id"), id));
        
 	
        try{
			tx = session.beginTransaction();
			session.createQuery(deleteCriteria).executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
        
        return true;	
     }

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		sessionFactory.getCurrentSession().update(jobTitle);
		return true;

	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(jobTitle);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				e.printStackTrace();
				return false;
			}
		} finally {
			session.close();
		}
		return true;

	}

	@Override
	public JobTitle getJobTitleById(int id) {
		return jdbcTemplate.queryForObject(SQL_GET_JOB_BY_ID, new Object[] { id }, new JobTitleMapper());
	}
}