package com.metacube.restProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restProject.dao.connection.Connect;
import com.metacube.restProject.dao.queries.CategoryQueries;
import com.metacube.restProject.models.Category;


public class MySQLCategoryDao implements CategoryDao {
    private static MySQLCategoryDao mySQLCategoryrDao = new MySQLCategoryDao();

    private MySQLCategoryDao() {
    }

    public static MySQLCategoryDao getInstance() {
        return mySQLCategoryrDao;
    }

	@Override
	public List<Category> getAll() {
		List<Category> listOfCategories = new ArrayList<Category>();
		String query = CategoryQueries.SELECT_ALL_CATEGORY;
		try(Connection conn = Connect.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset =  pstmt.executeQuery();	
		){
			while(rset.next()){
				int id = rset.getInt("category_id");
				String categoryName = rset.getString("category_name");
				
				Category category  = new Category();
				category.setCategoryName(categoryName);
				category.setId(id);
				listOfCategories.add(category);
			}
		}catch(Exception e){
			return null;
		}

			return listOfCategories;
	}

	@Override
	public boolean create(Category t) {
		String query = CategoryQueries.INSERT_QUERY;
		boolean isInsertedFlag = false;
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, t.getCategoryName());
			isInsertedFlag = pstmt.executeUpdate()==1?true:false;
		}catch(Exception e){
			isInsertedFlag = false;
		}
		return isInsertedFlag;
	}

	@Override
	public boolean update(Category t) {
		String query = CategoryQueries.UPDATE_QUERY;
		boolean isUpdatedFlag = false;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, t.getCategoryName());
			pstmt.setInt(2, t.getId());
			isUpdatedFlag = pstmt.executeUpdate()==1?true:false;
		}catch(Exception e){
			isUpdatedFlag = false;
		}
		return isUpdatedFlag;
	}

}
