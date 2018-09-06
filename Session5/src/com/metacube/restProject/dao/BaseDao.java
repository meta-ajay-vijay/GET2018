package com.metacube.restProject.dao;

import java.util.List;

public interface BaseDao<T> {

	public List<T> getAll();

	public boolean update(T t);
	
	public boolean create(T t);
}
