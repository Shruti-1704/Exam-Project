package com.app.services;

import java.util.List;
import java.util.Set;

import com.app.model.User;
import com.app.model.User_Role;

public interface UserService 
{
	// create user 
		public User createUser(User user, Set<User_Role> user_roles) throws Exception;

		// get user by username
		public User getUser(String username) throws Exception;
		
		// get user by uid
		public User getUserByUid(int uid) throws Exception;

		// delete user by uid
		public void deleteUser(int uid) throws Exception;
		
		// update user
		public User updateUser(User user,Set<User_Role> user_roles) throws Exception;

		// get all users
		public List<User> getAllUsers();
}
