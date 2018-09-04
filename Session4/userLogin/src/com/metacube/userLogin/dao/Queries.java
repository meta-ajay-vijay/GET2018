package com.metacube.userLogin.dao;

public class Queries {
public static final String SELECT_ALL = "SELECT user_id,first_name,last_name,age,dob,mobile_number,email,password,org_name,image_url FROM user_info;";
public static final String INSERT_USER = "INSERT INTO user_info(first_name, last_name,age,dob,mobile_number,email,password,org_name) VALUES (?,?,?,?,?,?,?,?);";
public static final String UPDTAE_USER = "UPDATE user_info SET first_name = ?, last_name = ?, age = ?, mobile_number = ? , org_name = ? WHERE user_id = ?";
public static final String SELECT_FRIENDS = "SELECT user_id,first_name,last_name,age,dob,mobile_number,email,password,org_name,image_url FROM user_info WHERE org_name = ? AND user_id <> ?";
public static final String INSERT_IMAGE = "UPDATE user_info SET image_url = ? WHERE user_id = ?";
}
