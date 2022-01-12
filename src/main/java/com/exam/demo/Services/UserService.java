package com.exam.demo.Services;

import java.util.Set;

import com.exam.demo.Entity.User;
import com.exam.demo.Entity.UserRole;

public interface UserService {

	// Method for creating user
	public User createuser(User user , Set<UserRole> userrole) throws Exception;
	
	//find user by username
	public User getUser(String username);

	public void deleteUser(Long id);
	
	public User updateUser(User user);
}
