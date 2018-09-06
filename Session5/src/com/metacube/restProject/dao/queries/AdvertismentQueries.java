package com.metacube.restProject.dao.queries;

public class AdvertismentQueries {
	public static final String SELECT_ALL_CATEGORY = "SELECT advertisment_id, advertisment_title, advertisment_description, category_id FROM advertisment"; 
	public static final String UPDATE_QUERY = "UPDATE advertisment SET advertisment_title = ?, advertisment_description=?, category_id = ? WHERE advertisment_id = ?;";
	public static final String INSERT_QUERY = "INSERT INTO advertisment(advertisment_title, advertisment_description,category_id) VALUES (?,?,?);";
	public static final String GET_BY_CATEFORY_QUERY = "SELECT advertisment_id, advertisment_title, advertisment_description, category_id FROM advertisment WHERE category_id = ?; ";
	public static final String DELETE_QUERY = "DELETE FROM advertisment WHERE advertisment_id = ?;";
	

}
