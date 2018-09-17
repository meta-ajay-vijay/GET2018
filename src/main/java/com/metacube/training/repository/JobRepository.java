package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Job;

public interface JobRepository<J> extends JpaRepository<Job, Long>{

}
