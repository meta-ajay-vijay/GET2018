package com.metacube.userLogin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.userLogin.dao.connection.Connect;
import com.metacube.userLogin.models.User;

public class MySQLUserDao implements UserDao {
    private static MySQLUserDao mySQLUserDao = new MySQLUserDao();

    private MySQLUserDao() {
    }

    public static MySQLUserDao getInstance() {
        return mySQLUserDao;
    }

	@Override
	public List<User> getAll() {
		List<User> listOfUserData = new ArrayList<User>();
		String query = Queries.SELECT_ALL;
			try(Connection conn = Connect.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset =  pstmt.executeQuery();	
		){
			while(rset.next()){
				int userId = rset.getInt("user_id");
				String firstName = rset.getString("fisrt_name");
				String lastName = rset.getString("last_name");
				int age  = rset.getInt("age");
				String mobile = rset.getString("mobile_number");
				String email = rset.getString("email");
				String password = rset.getString("password");
				String orgName = rset.getString("org_name");
				String imageUrl = rset.getString("image_url");
				Date date = rset.getDate("dob");
				
				User user = new User(firstName, lastName,age, date, mobile, email, password, orgName);
				user.setImageUrl(imageUrl);
				user.setId(userId);
				
				listOfUserData.add(user);
			}
		}catch(Exception e){
			return null;
		}
			return listOfUserData;
	}

	@Override
	public boolean insert(User entity) {
		String query = Queries.INSERT_USER; 
		int rowInserted= 0;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setInt(3, entity.getAge());
			pstmt.setDate(4, entity.getDob());
			pstmt.setString(5, entity.getMobileNumber());
			pstmt.setString(6, entity.getEmail());
			pstmt.setString(7, entity.getPassword());
			pstmt.setString(8, entity.getOrgName());
			rowInserted = pstmt.executeUpdate();

		}catch(Exception e){
			rowInserted = 2;
		}
		return (rowInserted==1);
		
	}

	@Override
	public boolean update(User t) {
		String query = Queries.UPDTAE_USER;
		int rowUpdated= 0;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, t.getFirstName());
			pstmt.setString(2, t.getLastName());
			pstmt.setInt(3, t.getAge());
			pstmt.setString(4, t.getMobileNumber());
			pstmt.setString(5, t.getOrgName());
			pstmt.setInt(6, t.getId());
			rowUpdated = pstmt.executeUpdate();
			
		}catch(Exception e){
			rowUpdated = 2;
			System.out.println("sdsda"+e.getMessage());
		}
		return (rowUpdated==1);
		
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getFriends(User user) {
		List<User> friendList = new ArrayList<User>();
		String query = Queries.SELECT_FRIENDS; 
		try(
				Connection conn = Connect.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, user.getOrgName());
			pstmt.setInt(2, user.getId());
			ResultSet rset =  pstmt.executeQuery();
			
			while(rset.next()){
				int userId = rset.getInt("user_id");
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
				int age  = rset.getInt("age");
				String mobile = rset.getString("mobile_number");
				String temp_email = rset.getString("email");
				String password = rset.getString("password");
				String orgName = rset.getString("org_name");
				String imageUrl = rset.getString("image_url");
				Date date = rset.getDate("dob");
				
				User tempUser = new User(firstName, lastName,age, date, mobile, temp_email, password, orgName);
				tempUser.setImageUrl(imageUrl);
				tempUser.setId(userId);
				friendList.add(tempUser);
			}
		
		}catch(Exception e){
			System.out.println("error aay");
			friendList = null;
		}
			return friendList;
	}

	@Override
	public User getUser(String email) {
		List<User> listOfUserData = new ArrayList<User>();
		String query = "SELECT user_id,first_name,last_name,age,dob,mobile_number,email,password,org_name,image_url FROM user_info WHERE email LIKE '"+ email +"';";
		try(Connection conn = Connect.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset =  pstmt.executeQuery();	
		){
			while(rset.next()){
				int userId = rset.getInt("user_id");
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
				int age  = rset.getInt("age");
				String mobile = rset.getString("mobile_number");
				String temp_email = rset.getString("email");
				String password = rset.getString("password");
				String orgName = rset.getString("org_name");
				String imageUrl = rset.getString("image_url");
				Date date = rset.getDate("dob");
				
				
				User user = new User(firstName, lastName,age, date, mobile, temp_email, password, orgName);
				user.setImageUrl(imageUrl);
				user.setId(userId);
				listOfUserData.add(user);
			}
		}catch(Exception e){
			return null;
		}
		
		return listOfUserData.size()==0?null:listOfUserData.get(0);
	}

	@Override
	public boolean insertImage(String imageUrl, User user) {
		String query = Queries.INSERT_IMAGE;

		int rowUpdated= 0;
		
		try(Connection conn = Connect.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, imageUrl);
			pstmt.setInt(2, user.getId());
			rowUpdated = pstmt.executeUpdate();
			
		}catch(Exception e){
			rowUpdated = 2;
			System.out.println("sdsda"+e.getMessage());
		}
		return (rowUpdated==1);
	}
	

}
