package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.EmployeeAndJobDetails;

public interface EmployeeJobRepository<E> extends JpaRepository<EmployeeAndJobDetails, String> {

}
