package com.metacube.restProject.service;

import java.util.List;

import com.metacube.restProject.dao.AdvertismentDao;
import com.metacube.restProject.enums.DBType;
import com.metacube.restProject.enums.EntityName;
import com.metacube.restProject.enums.Status;
import com.metacube.restProject.factory.DaoFactory;
import com.metacube.restProject.models.Advertisment;

public class AdvertismentServices {
	private static AdvertismentServices advertismentServices = new AdvertismentServices();
	private AdvertismentDao advertismentDao = (AdvertismentDao) DaoFactory.getDaoForEntity(DBType.MY_SQL, EntityName.ADVERTISMENT);
	
	private AdvertismentServices(){}
	
	public static AdvertismentServices getInstance(){
		return advertismentServices;
	}
	
	public List<Advertisment> getAll(){
		return advertismentDao.getAll();
	}
	
	public Status createAdvertisment(Advertisment advertisment){
		if(advertismentDao.create(advertisment)){
			return Status.CREATED;
		}else{
			return Status.ERROR;
		}
	}
	
	public Status deleteAdvertisment(int id){
		if(advertismentDao.deleteAdvertisment(id)){
			return Status.DELETED;
		}else{
			return Status.ERROR;
		}
	}
	
	public Status updateAdvertisment(Advertisment advertisment){
		if(advertismentDao.update(advertisment)){
			return Status.UPDATED;
		}else{
			return Status.ERROR;
		}
	}
	
	public List<Advertisment> getAdvertismentByCategory(int id){
		return advertismentDao.GetByCategoryId(id);
	}
	
}
