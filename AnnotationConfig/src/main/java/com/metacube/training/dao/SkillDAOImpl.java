package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;
@Repository 
public class SkillDAOImpl implements SkillDAO {

private JdbcTemplate JdbcTemplate;

	private final String GET_ALL_Skill_Query = "select * from skill_master";
	private final String INSERT_QUERY = "INSERT INTO skill_master(skill_name) VALUES (?)";


	
	@Autowired
	public SkillDAOImpl(DataSource dataSource){
		JdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Skill> getAllSkills() {
		return JdbcTemplate.query(GET_ALL_Skill_Query,new SkillMapper());
	}

	@Override
	public boolean createSkill(Skill skill) {
		return JdbcTemplate.update(INSERT_QUERY,skill.getName())>0;
	}

}
