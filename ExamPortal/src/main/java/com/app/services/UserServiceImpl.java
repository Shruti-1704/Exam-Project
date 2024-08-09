package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CustomException;
import com.app.model.User;
import com.app.model.User_Role;
import com.app.repository.RoleRepo;
import com.app.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;

	
//================ create user ======================================================================================================================
	@Override
	@Transactional
	public User createUser(User user, Set<User_Role> user_roles) throws Exception
	{

	 User local = this.userRepo.findByUsername(user.getUsername());
		
	 if(local != null)
	 {
		 System.out.println("\n=================================================================================================================\n"
		           + "         Message: User already present with username: "+ user.getUsername() +" , try using different username...  \n"
		           + "==========================================================================================================================");
		
		 throw new CustomException("Exception: User already present with username: "+ user.getUsername() +" , try using different username...");
		 		          
		 
	 }else {
		 //create user
		 
		 for(User_Role ur:user_roles)
		 {
			 System.out.println("=====================================================================");
			 System.out.println(ur.getRole());
			 System.out.println("=====================================================================");
			 this.roleRepo.save(ur.getRole());
		 }
		 
		 user.getUser_roles().addAll(user_roles);
		local = this.userRepo.save(user);
	 }
	 
	 return local;
	}

//================ get user by uid ======================================================================================================================

	@Override
	@Transactional
	public User getUserByUid(int uid) throws Exception {
		
		Optional<User> user = this.userRepo.findById(uid);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			 System.out.println("\n====================================================================\n"
	 		           + "         Message: There is no User with uid: "+uid+" exists... \n"
	 		           + "====================================================================");
			
			 throw new CustomException(" Exception: There is no User with uid: "+uid+" exists...");

			 
		
		}
		
	
	}
	
//================ get user by username ======================================================================================================================

	@Override
	@Transactional
	public User getUser(String username) throws Exception {
		
		if(this.userRepo.findByUsername(username) == null)
		{
			 System.out.println("\n====================================================================\n"
	 		           + "         Message: There is no User with username: "+username+" exists...  \n"
	 		           + "====================================================================");
			
			 throw new CustomException(" Exception: There is no User with username: "+username+" exists...");
		}
		return this.userRepo.findByUsername(username);
	}

//================ delete user by uid ======================================================================================================================

	@Override
	@Transactional
	public void deleteUser(int uid) throws Exception {
		
		Optional<User> user = this.userRepo.findById(uid);
		if(user.isEmpty())
		{
			 System.out.println("\n====================================================================\n"
	 		           + "         Message: There is no User with uid: "+uid+" exists...  \n"
	 		           + "====================================================================");
			
			 throw new CustomException("Exception: There is no User with uid: "+uid+" exists...");
			 
		
		}
		
		this.userRepo.deleteById(uid);
		
		
	}

	
//================ update user ======================================================================================================================

	@Override
	@Transactional
	public User updateUser(User user,Set<User_Role> user_roles) throws Exception {
		
		User local;
	
		
		if(this.userRepo.getByUnameAndNouid(user.getUsername(), user.getUid()) != null)
		{
		 System.out.println("\n=======================================================================================================================\n"
		           + "         Message: User already present with username: "+user.getUsername()+" , try using different username !! \n"
		           + "=================================================================================================================================");
		
		 throw new CustomException("Exception: User already present with username: "+user.getUsername()+" , try using different username !!");
		 
		}else {
		 //update user
			
			 for(User_Role ur:user_roles)
			 {
				 System.out.println("=====================================================================");
				 System.out.println(ur.getRole());
				 System.out.println("=====================================================================");
				 this.roleRepo.save(ur.getRole());
			 }
			 
			 user.getUser_roles().addAll(user_roles);
			 
		//	 user.setUser_roles(user_roles);
			 
			 	local = this.userRepo.save(user);
		 	}
		 	return local;

	 	}
	
//========== get all users ============================================================================================================================
	

	@Override
	@Transactional
	public List<User> getAllUsers() {
		
		return this.userRepo.findAll();
	}

	
//======================================================================================================================================
	
	
	
}
