package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.ProjectDAO;
import com.metacube.training.model.Project;
@Transactional
@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;


/*	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/

	private final String HQL_FIND_PROJECT = "FROM Project WHERE project_id = :id";
	private final String HQL_DELETE_PROJECT = "delete from Project where project_id = :id";
	private final String HQL_UPDATE_PROJECT = "update Project set project_name = :name,project_description =:description, start_date  = :startDate, end_date  = :endDate where project_id = :id";
	private final String HQL_GET_ALL = "from Project";

/*
	public Project getProjectById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new ProjectMapper());
	}

	public List<Project> getAllProjects() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	public boolean deleteProject(Project person) {
		return jdbcTemplate.update(SQL_DELETE_PROJECT, person.getId()) > 0;
	}

	public boolean updateProject(Project person) {
		return jdbcTemplate.update(SQL_UPDATE_PROJECT, person.getName(),
				person.getDescription(), person.getStartDate(),person.getEndDate(), person.getId()) > 0;
	}

*/	public boolean createProject(Project person) {
/*		return jdbcTemplate.update(SQL_INSERT_PROJECT, person.getName(),
				person.getDescription(), person.getStartDate(),person.getEndDate()) > 0;*/
		 sessionFactory.getCurrentSession().save(person);
		 return true;
	}
@Override
public Project getProjectById(Long id) {
	TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(HQL_FIND_PROJECT);
	query.setParameter("id", id);
	return query.getSingleResult();
}
@Override
public List<Project> getAllProjects() {
	TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(HQL_GET_ALL);
	return query.getResultList();
}
@Override
public boolean deleteProject(Project project) {
	TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(HQL_DELETE_PROJECT);
	query.setParameter("id", project.getId());
	return (query.executeUpdate()>0);
}
@Override
public boolean updateProject(Project project) {
	TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery(HQL_UPDATE_PROJECT);
	query.setParameter("name", project.getName());
	query.setParameter("description", project.getDescription());
	query.setParameter("startDate", project.getStartDate());
	query.setParameter("endDate", project.getEndDate());
	query.setParameter("id", project.getId());
	
	return (query.executeUpdate()>0);
}
}