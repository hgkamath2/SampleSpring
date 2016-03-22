package com.sample.serviceImpl;

import java.util.List;

import javax.inject.Singleton;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.UserDao;
import com.sample.model.User;
import com.sample.service.UserService;

@Service("userService")
@Transactional

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDam; 
	
	

	@Override	
	public String greet(String who) {
		System.out.println("greeeeet");
        return String.format("hello, %s!", who);
    }

	@Override
	public Integer addUser(User usr) {
		return userDam.addUser(usr);
	}

	@Override
	public List<User> getAllUsers() {
		return userDam.getAllUsers();
	}

	@Override
	public User getUser(int userId) {
		if(userDam == null)
			System.out.println("NULLLL");
		else
			System.out.println("is not NULLLL");
		return userDam.getUser(userId);
	}

	@Override
	public Integer updateUser(User usr) {
		User temp = userDam.getUser(usr.getUserId());
		if(temp != null)
			temp.userCopy(usr);
		return temp.getUserId();
	}
	
	@Override
	public void deleteUser(User usr) {
		userDam.deleteUser(usr);
	}

}
