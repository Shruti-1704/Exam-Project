package com.app.services;

import com.app.model.Role;
import com.app.model.User;
import com.app.model.User_Role;

public interface User_RoleService 
{

	// get User_role
	public User_Role  getUser_roleFromUserAndRole(User user,Role role) throws Exception;
}
