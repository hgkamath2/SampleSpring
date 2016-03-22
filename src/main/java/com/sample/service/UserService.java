package com.sample.service;

import java.util.List;

import com.sample.model.User;

//interface to define methods exposed to UI or Rest or any other modules outside of DB layer
public interface UserService {

	public Integer addUser(User usr);

	public List<User> getAllUsers();

	public User getUser(int userId);

	public Integer updateUser(User usr);
	
	public void deleteUser(User usr);

	public String greet(String who);
}
