package com.app.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Role;
import com.app.model.User;
import com.app.model.User_Role;
import com.app.services.UserService;
import com.app.services.User_RoleService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*")
public class UserController 
{
	
	 @Autowired
	    private UserService userService;
//	    @Autowired
//	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @PostMapping("/create")
	    public User createUser(@RequestBody User user) throws Exception {

	        //user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
	        Set<User_Role> roles = new HashSet<>();
	        Role role = new Role();
	        role.setRid(45);
	        role.setRolename("normal");

	        User_Role userRole = new User_Role();
	        userRole.setUser(user);
	        userRole.setRole(role);
	        roles.add(userRole);
	        return this.userService.createUser(user, roles);
	    }

	    @GetMapping("/{username}")
	    public User getUser(@PathVariable("username") String username) throws Exception {
	        return userService.getUser(username);
	    }

	    @GetMapping("/getAll")
	    public List<User> getAllUser() {
	        return userService.getAllUsers();
	    }

	    @PutMapping("/{id}")
	    public User updateUser(@RequestBody User user, @PathVariable("id") Set<User_Role> id) throws Exception {
	        return userService.updateUser(user, id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable("id") int id) throws Exception {
	        userService.deleteUser(id);
	    }
	    
	    
//	@Autowired
//	private UserService userServ;
//	
//	@Autowired(required=true)
//	private User_RoleService user_roleServ;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	
//	
//	
////================ create user ======================================================================================================================
//	
//	/*
//	 	{      
//		   "username":"yashmore",
//           "firstname":"Yash",
//           "lastname":"More",
//           "password":"1234",
//           "email":"yash@gmail.com",
//           "phone":"1234567891",
//           "profile":"default.png"   
//		}
//	*/
//	@PostMapping("/create")
//	public User createUser(@RequestBody User user) throws Exception	
//	{
//		//user.setProfile("profile.png");
//		
//		// encoding password with PasswordEncoder
//		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//		
//		Role role = new Role();
//		role.setRid(2);
//		role.setRolename("ROLE_NORMAL");
//		
//		User_Role user_role = new User_Role();
//		user_role.setUser(user);
//		user_role.setRole(role);
//		
//			
//		Set<User_Role> user_roles = new HashSet<>();
//		user_roles.add(user_role);
//		
//	
//		return this.userServ.createUser(user, user_roles);
//	}
//	
////========== get user by uid ======================================================================================================================
//		
//		@GetMapping("/uid/{uid}")
//		public User getUser(@PathVariable("uid") int uid) throws Exception
//		{
//			return this.userServ.getUserByUid(uid);
//		}
//	
//	
////========== get user by username ======================================================================================================================
//	
//	@GetMapping("/username/{username}")
//	public User getUser(@PathVariable("username") String username) throws Exception
//	{
//		return this.userServ.getUser(username);
//	}
//	
//	
////========== get all users ======================================================================================================================
//	
//	@GetMapping("/all")
//	public List<User> getAllUsers()
//	{
//		
//		return this.userServ.getAllUsers();
//	}
//	
////=========== delete user by uid ======================================================================================================================
//	
//	@DeleteMapping("/delete/{uid}")
//	public void deleteUser(@PathVariable("uid") int uid) throws Exception
//	{
//		
//		this.userServ.deleteUser(uid);
//		
//	}
//	
//	
////========= update user ======================================================================================================================
//
//	/*
//	 	{    
//	 	   "uid":"2",  
//		   "username":"yashmore",
//           "firstname":"Yash",
//           "lastname":"More",
//           "password":"1234",
//           "email":"yash@gmail.com",
//           "phone":"1234567891",
//           "profile":"default.png"   
//		}
//	*/
//	
//	@PutMapping("/update")
//	public User updateUser(@RequestBody User user) throws Exception
//	{
//		
//		// encoding password with PasswordEncoder
//		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//		
//		
//		Role roleAdmin = new Role();
//		roleAdmin.setRid(1);
//		roleAdmin.setRolename("ROLE_Admin");
//		
//		
//		Role roleNormal = new Role();
//		roleNormal.setRid(2);
//		roleNormal.setRolename("ROLE_NORMAL");
//		
//		User_Role user_role = new User_Role();
//		
//		Role role = new Role();
//		if(user.getUsername() == "admin" || user.getUsername().equals("admin"))
//		{
//			role = roleAdmin;
//		}
//		else {
//			role = roleNormal;
//		}
//	
//			User_Role local = this.user_roleServ.getUser_roleFromUserAndRole(user,role);
//		
//		user_role.setUrid(local.getUrid());
//		user_role.setUser(user);
//		user_role.setRole(role);
//		
//		Set<User_Role> user_roles = new HashSet<>();
//		user_roles.add(user_role);
//		
//	
//		return this.userServ.updateUser(user, user_roles);
//		
//	}
//	
////======================================================================================================================================
}
