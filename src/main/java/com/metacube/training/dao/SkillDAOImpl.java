package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.EmployeeModel;

import com.metacube.training.model.Skill;

@Transactional
@Repository
public class SkillDAOImpl implements SkillDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	private JdbcTemplate JdbcTemplate;

	private final String GET_ALL_Skill_Query = "select * from skill_master";
	private final String INSERT_QUERY = "INSERT INTO skill_master(skill_name) VALUES (?)";

	@Autowired
	public SkillDAOImpl(DataSource dataSource) {
		JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Skill> getAllSkills() {
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> skillRoot = criteria.from(Skill.class);
        criteria.select(skillRoot);
		
        List<Skill> skillList = session.createQuery(criteria).getResultList();
		
		session.close();
   
		return skillList;
	}

	@Override
	public boolean createSkill(Skill skill) {
		return JdbcTemplate.update(INSERT_QUERY, skill.getName()) > 0;
	}

	@Override
	public List<EmployeeModel> getEmployeesBySkills(String skill) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Skill> query = session.getCriteriaBuilder().createQuery(Skill.class);
		Root<Skill> skillRoot = query.from(Skill.class);
		query.select(skillRoot).where(builder.equal(skillRoot.get("name"), skill));
		return session.createQuery(query).getResultList().get(0).getEmployeesSkills();
	}
}
