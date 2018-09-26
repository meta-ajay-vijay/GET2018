package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.UserRole;

public interface UserRoleRepository<U> extends JpaRepository<UserRole, Long> {
	public List<UserRole> findByEmpCode(String empCode);
}
