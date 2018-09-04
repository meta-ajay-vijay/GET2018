package com.metacube.userLogin.facade;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.models.User;
import com.metacube.userLogin.service.UserServices;
import com.metacube.userLogin.view.ProfileView;
import com.metacube.userLogin.view.UserFriendView;

public class UserFacade {

	private static UserFacade productFacade = new UserFacade();
	private UserServices userServices = UserServices.getInstance();

	public static UserFacade getInstance() {
		return productFacade;
	}

	public Status registerUser(String firstName, String lastName, int age,
			String dob, String contact, String email, String password,
			String orgName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = dob;
		Date date = null;
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Status status = userServices.registerUser(new User(firstName, lastName,
				age, date, contact, email, password, orgName));
		return status;
	}

	public boolean checkUserEmailPassword(String email, String password) {
		return userServices.checkIdPs(email, password);
	}

	public ProfileView getUserProfileData(String email) {
		User user = userServices.getUserDataOf(email);
		String name = user.getFirstName() + " " + user.getLastName();

		ProfileView profileview = new ProfileView(name, user.getAge(),
				user.getMobileNumber(), user.getOrgName(), user.getImageUrl());
		return profileview;

	}
	
	public Status updateUserProfleData(String name, String age, String contact, String org, String email){
		return userServices.updateDataOfUser(name,age,contact,org,email);
	}
	
	public List<UserFriendView> getUserFriendsData(String email){
		List<User> listOfUsersFriedns =  userServices.getUserFriendsData(email);
		List<UserFriendView> listOfUSerFriendsInFriendView = new ArrayList<UserFriendView>();
		for(User user:listOfUsersFriedns){
			String name = user.getFirstName()+ " " + user.getLastName();
			UserFriendView userFriendView = new UserFriendView(name, user.getOrgName(), user.getAge(), user.getMobileNumber());
			userFriendView.setId(user.getId());
			userFriendView.setEmail(user.getEmail());
			listOfUSerFriendsInFriendView.add(userFriendView);
		}
		return listOfUSerFriendsInFriendView;
	}
	
	public Status addImageUrl(String imageUrl,String email){
		return userServices.addImageUrl(imageUrl,email);
	}

}
