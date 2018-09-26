package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.UserRole;

public interface UserRoleService {
	public List<UserRole> findUser(String empCode);
}
