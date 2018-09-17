package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.connection.Connect;
import com.metacube.training.dao.daointerfaces.SkillDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO{
	
	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	private final String SQL_GET_ALL = "select * from skill_master";
	private final String SQL_INSERT_SKILL = "insert into skill_master(skill_name) values(?)";
	
	
	@Override
	public Skill getSkillById(Long id) {
		return null;
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> resultList = new ArrayList<Skill>();
		try(
				Connection connect = Connect.getConnection();
				PreparedStatement stmt =  connect.prepareStatement(SQL_GET_ALL);)
			{
				ResultSet rset =  stmt.executeQuery();
				while(rset.next())
				{
					int id = rset.getInt("skill_id");
					String title = rset.getString("skill_name");
					Skill newSkill = new Skill();
					newSkill.setId((long)id);;
					newSkill.setName(title);
					resultList.add(newSkill);
				}
			}catch(SQLException e)
		{
				e.fillInStackTrace();
		}	
		return resultList;
		/*Criteria cr = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		List results = cr.list();
		return results;*/
		/*Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Skill> criteria = (CriteriaQuery) builder.createQuery(Skill.class);
		Root<Skill> employeeRoot =  criteria.from(Skill.class);
		criteria.select(employeeRoot);
		List<Skill> skills = session.createQuery(criteria).getResultList();
		session.close();
		return skills;*/
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createSkill(Skill skill) {
		boolean created =false;
		try(
				Connection connect = Connect.getConnection();
				PreparedStatement stmt =  connect.prepareStatement(SQL_INSERT_SKILL);
			)
			{
				stmt.setString(1, skill.getName());
			    stmt.executeUpdate();
				created = true;
			}catch(SQLException e)
		{
				created = false;
		}	
		return created;
		/*sessionFactory.getCurrentSession().save(skill);
		return true;*/
	}
}
