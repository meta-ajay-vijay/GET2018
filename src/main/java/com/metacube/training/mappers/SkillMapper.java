package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Skill;

public class SkillMapper implements RowMapper<Skill> {

	@Override
	public Skill mapRow(ResultSet rset, int i) throws SQLException {
		Skill skill = new Skill();
		skill.setId(rset.getInt("skill_id"));
		skill.setName(rset.getString("skill_name"));
		return skill;
	}
}
