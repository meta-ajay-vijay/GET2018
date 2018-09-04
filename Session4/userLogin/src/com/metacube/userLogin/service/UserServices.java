package com.metacube.userLogin.service;

import java.util.ArrayList;
import java.util.List;

import com.metacube.userLogin.dao.UserDao;
import com.metacube.userLogin.enums.DBType;
import com.metacube.userLogin.enums.EntityName;
import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.factory.DaoFactory;
import com.metacube.userLogin.models.User;
import com.metacube.userLogin.view.ProfileView;

public class UserServices {

    private static UserServices userServices = new UserServices();

    UserDao userDao = (UserDao) DaoFactory.getDaoForEntity(DBType.MY_SQL, EntityName.USER);

    public static UserServices getInstance() {
        return userServices;
    }
    
	public Status registerUser(User user) {
		User temp_user = userDao.getUser(user.getEmail());
		
		if (temp_user != null) {
			return Status.DUPLICATE_USER;
		} else if (userDao.insert(user)) {
			return Status.CREATED;
		} else {
			return Status.ERROR;
		}
	}
	
	public boolean checkIdPs(String email,String password){
		boolean checkResultFalg = false;
		User temp_user = userDao.getUser(email);
		if(temp_user!=null){
			checkResultFalg =  temp_user.getPassword().equals(password);
		}
		
		return checkResultFalg;
	}
	
	public User getUserDataOf(String email){
		return userDao.getUser(email);
	}
	
	public Status updateDataOfUser(String name, String age, String contact, String org, String email){
		
		User user = userDao.getUser(email);
		
		String[]firstNameAndLastName = name.split(" ");
		
		user.setFirstName(firstNameAndLastName[0]);
		user.setLastName(firstNameAndLastName[1]);
		user.setAge(Integer.parseInt(age));
		user.setMobileNumber(contact);
		user.setOrgName(org);
		
		boolean flag = userDao.update(user);
		if(flag){
			return Status.UPDATED;
		}else{
			return Status.OK;
		}
	}
	public List<User> getUserFriendsData(String email){
		User user  = userDao.getUser(email);
		List<User> friendList = userDao.getFriends(user);
		return friendList;
	}
	
	public Status addImageUrl(String imageUrl,String email){
		User user = userDao.getUser(email);
		if(userDao.insertImage(imageUrl,user)){
			return Status.OK;
		}else{
			return Status.ERROR;
		}
	}
}
