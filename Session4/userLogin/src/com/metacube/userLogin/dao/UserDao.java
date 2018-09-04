package com.metacube.userLogin.dao;

import java.util.List;

import com.metacube.userLogin.models.User;

public interface UserDao extends BaseDao<User> {
	public List<User> getFriends(User user);
	public User getUser(String email);
	public boolean insertImage(String imageUrl, User user);

}
