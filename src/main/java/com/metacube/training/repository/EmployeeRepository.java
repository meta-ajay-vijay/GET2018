package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Employee;

public interface EmployeeRepository<E> extends JpaRepository<Employee, String>{
	//public Employee findByEmailId(String emailId);
}
