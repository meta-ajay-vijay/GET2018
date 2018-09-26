package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.UserRole;
import com.metacube.training.repository.UserRoleRepository;
import com.metacube.training.service.interfaces.UserRoleService;

@Service
public class UserServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository<UserRole> userRoleRepository;

	@Override
	public List<UserRole> findUser(String empCode) {
		return userRoleRepository.findByEmpCode(empCode);
	}

}
