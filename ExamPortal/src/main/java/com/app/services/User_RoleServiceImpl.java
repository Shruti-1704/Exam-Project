package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Role;
import com.app.model.User;
import com.app.model.User_Role;
import com.app.repository.User_RoleRepo;

@Service
public class User_RoleServiceImpl implements User_RoleService
{
	@Autowired
	private User_RoleRepo user_roleRepo;
	
	@Autowired
	private UserService userServ;
	
	
//================ get user_role ======================================================================================================================

	@Override
	public User_Role getUser_roleFromUserAndRole(User user, Role role) throws Exception 
	{
		User local = userServ.getUserByUid(user.getUid());
		
		return this.user_roleRepo.getByUAndR(local, role);
	}

	
//=====================================================================================================================================
}
