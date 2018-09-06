package com.metacube.restProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restProject.dao.connection.Connect;
import com.metacube.restProject.dao.queries.AdvertismentQueries;
import com.metacube.restProject.models.Advertisment;

public class MySQLAdvertismentDao implements AdvertismentDao {
    private static MySQLAdvertismentDao mySQLAdvertismentDao  = new MySQLAdvertismentDao();

    private MySQLAdvertismentDao() {
    }

    public static MySQLAdvertismentDao getInstance() {
        return mySQLAdvertismentDao;
    }
	
	
	@Override
	public List<Advertisment> getAll() {
		List<Advertisment> listOfAdvertisment = new ArrayList<Advertisment>();
		String query = AdvertismentQueries.SELECT_ALL_CATEGORY;
		try(Connection conn = Connect.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset =  pstmt.executeQuery();	
		){
			while(rset.next()){
				int id = rset.getInt("advertisment_id");
				String advertismentName = rset.getString("advertisment_title");
				String advertismentDescription = rset.getString("advertisment_description");
				int categoryId = rset.getInt("category_id");
				
				Advertisment advertisment  = new Advertisment();
				advertisment.setId(id);
				advertisment.setAdvertismentDescription(advertismentDescription);
				advertisment.setAdvertismentTitle(advertismentName);
				advertisment.setCategoryId(categoryId);
				
				listOfAdvertisment.add(advertisment);
			}
		}catch(Exception e){
			return null;
		}

			return listOfAdvertisment;
	}

	@Override
	public boolean update(Advertisment t) {
		String query = AdvertismentQueries.UPDATE_QUERY;
		boolean isUpdatedFlag = false;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, t.getAdvertismentTitle());
			pstmt.setString(2, t.getAdvertismentDescription());
			pstmt.setInt(3, t.getCategoryId());
			pstmt.setInt(4, t.getId());
			
			isUpdatedFlag = pstmt.executeUpdate()==1?true:false;
		}catch(Exception e){
			System.out.println(e.getMessage());
			isUpdatedFlag = false;
		}
		return isUpdatedFlag;
	}
	

	@Override
	public boolean create(Advertisment t) {
		String query = AdvertismentQueries.INSERT_QUERY;
		boolean isInsertedFlag = false;
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, t.getAdvertismentTitle());
			pstmt.setString(2, t.getAdvertismentDescription());
			pstmt.setInt(3, t.getCategoryId());
			isInsertedFlag = pstmt.executeUpdate()==1?true:false;
		}catch(Exception e){
			isInsertedFlag = false;
		}
		return isInsertedFlag;
	}

	@Override
	public List<Advertisment> GetByCategoryId(int categoryId) {
		List<Advertisment> listOfAdvertisment = new ArrayList<Advertisment>();
		String query = AdvertismentQueries.GET_BY_CATEFORY_QUERY;
		try(Connection conn = Connect.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
				
			
		){
			pstmt.setInt(1, categoryId);
			ResultSet rset =  pstmt.executeQuery();	
			while(rset.next()){
				int id = rset.getInt("advertisment_id");
				String advertismentName = rset.getString("advertisment_title");
				String advertismentDescription = rset.getString("advertisment_description");
				int categoryIdd = rset.getInt("category_id");
				
				Advertisment advertisment  = new Advertisment();
				advertisment.setId(id);
				advertisment.setAdvertismentDescription(advertismentDescription);
				advertisment.setAdvertismentTitle(advertismentName);
				advertisment.setCategoryId(categoryIdd);
				
				listOfAdvertisment.add(advertisment);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}

			return listOfAdvertisment;
	}

	@Override
	public boolean deleteAdvertisment(int id) {
		String query = AdvertismentQueries.DELETE_QUERY;
		boolean isUpdatedFlag = false;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, id);
			isUpdatedFlag = pstmt.executeUpdate()==1?true:false;
		}catch(Exception e){
			System.out.println(e.getMessage());
			isUpdatedFlag = false;
		}
		return isUpdatedFlag;
	}
}






