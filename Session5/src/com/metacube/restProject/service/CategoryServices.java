package com.metacube.restProject.service;

import java.util.List;

import com.metacube.restProject.dao.CategoryDao;
import com.metacube.restProject.enums.DBType;
import com.metacube.restProject.enums.EntityName;
import com.metacube.restProject.enums.Status;
import com.metacube.restProject.factory.DaoFactory;
import com.metacube.restProject.models.Category;

public class CategoryServices {
	private static CategoryServices categoryServices = new CategoryServices();
	private CategoryDao categoryDao = (CategoryDao) DaoFactory.getDaoForEntity(DBType.MY_SQL, EntityName.CATEGORY);
	
	private CategoryServices(){}
	
	public static CategoryServices getInstance(){
		return categoryServices;
	}
	
	public List<Category> getAllCategories(){
		return categoryDao.getAll();
	}
	
	public Status createCategory(Category category){
		if(categoryDao.create(category)){
			return Status.CREATED;
		}else{
			return Status.ERROR;
		}
	}
	
	public Status updateCategory(Category category){
		if(categoryDao.update(category)){
			return Status.UPDATED;
		}else{
			return Status.ERROR;
		}
	}

	
}
