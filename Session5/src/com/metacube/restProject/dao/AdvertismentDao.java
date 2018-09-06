package com.metacube.restProject.dao;

import java.util.List;

import com.metacube.restProject.models.Advertisment;

public interface AdvertismentDao extends BaseDao<Advertisment> {
	public List<Advertisment> GetByCategoryId(int category_id);
	public boolean deleteAdvertisment(int id);
	
}
