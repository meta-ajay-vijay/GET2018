package com.metacube.restProject.dao.queries;

public class CategoryQueries {
	public static final String SELECT_ALL_CATEGORY = "SELECT category_id,category_name FROM category;";
	public static final String INSERT_QUERY = "INSERT INTO category(category_name) VALUES(?)";
	public static final String UPDATE_QUERY = "UPDATE category SET category_name = ? WHERE category_id = ?";
}
