package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.daointerfaces.SkillDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.serviceinterface.SkillService;
import com.metacube.training.transferObjects.EmployeeSkills;


@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillDAO skillDAO;
	
	@Autowired
	private SkillRepository<Skill> skillRepository;

	@Override
	public Skill getSkillById(Long id) {
		return skillRepository.findOne(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	@Override
	public boolean deleteSkill(Long id) {
		try{
			skillRepository.delete(id);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createSkill(Skill skill) {
		try{
			skillRepository.save(skill);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
