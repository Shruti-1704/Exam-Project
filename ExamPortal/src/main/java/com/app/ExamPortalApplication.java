package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.model.Role;
import com.app.model.User;
import com.app.model.User_Role;
import com.app.repository.RoleRepo;
import com.app.repository.UserRepo;
import com.app.repository.User_RoleRepo;
import com.app.services.UserService;

@SpringBootApplication
public class ExamPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}
	
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Autowired
//	private RoleRepo roleRepo;
//	
//	@Autowired
//	private User_RoleRepo user_roleRepo;
//	
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	public void run(String... args) throws Exception {
//		
//		
//		User local = this.userRepo.findByUsername("admin");
//		 if(local == null)
//		 {
//		
//		//======== creating user(admin) without api========================================	
//		
//		 
//			User admin = new User();
//			admin.setUsername("admin");
//			admin.setFirstname("admin");
//			admin.setLastname("admin");
//			admin.setPassword(this.passwordEncoder.encode("admin"));
//			admin.setEmail("admin@gmail.com");
//			admin.setPhone("1234567891");
//			admin.setProfile("profile.png");
//			
//			this.userRepo.save(admin);
//		 
//		
//		//========  Role  ====================================================================================		
//		
//			Role role = new Role();
//			role.setRid(1);
//			role.setRolename("ROLE_ADMIN");
//			
//			this.roleRepo.save(role);
//		
//		//========= User_role ==================================================================================		
//		
//			User_Role user_role = new User_Role();
//			user_role.setUrid(1);
//			user_role.setRole(role);
//			user_role.setUser(admin);
//			
//			this.user_roleRepo.save(user_role);
//		
//		
//		 }
//	}

}
