package com.sample.dao;

import java.util.List;

import com.sample.model.User;

//interface/impl to wrap the jpa/hibernate calls
public interface UserDao {

	public Integer addUser(User usr);
	public List<User> getAllUsers();
	public User getUser(int userId);
	public Integer updateUser(User usr);
	public void deleteUser(User usr);
}
