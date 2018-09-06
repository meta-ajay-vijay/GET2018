package com.metacube.restProject.facade;

import java.util.List;

import com.metacube.restProject.enums.Status;
import com.metacube.restProject.models.Category;
import com.metacube.restProject.service.CategoryServices;

public class CategoryFacade {
	private static CategoryFacade categoryFacade = new CategoryFacade();
	private CategoryServices categoryServices = CategoryServices.getInstance();
	
	public static CategoryFacade getInstance(){
		return categoryFacade;
	}
	
	public List<Category> getAll(){
		return categoryServices.getAllCategories();
	}
	
	public Status createCategory(Category category){
		return categoryServices.createCategory(category);
	}
	
	public Status updateCategory(Category category){
		return categoryServices.updateCategory(category);
	}
	
}
