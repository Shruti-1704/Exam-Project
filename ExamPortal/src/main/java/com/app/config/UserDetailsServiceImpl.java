package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		//fetching user from 
	
		User user = this.userRepo.findByUsername(username);

		if(user == null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("Could not found user !!");
			
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		return customUserDetails;
	}
	
}


















































//package com.app.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.app.model.User;
//import com.app.repository.UserRepo;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService
//{
//
//@Autowired
//private UserRepo userrepo;
//
//public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//     User user=this.userrepo.findByUsername(s);
//     if(user==null)
//     {
//         System.out.println("User not found exception");
//         throw new UsernameNotFoundException("No user found");
//     }
//     return (UserDetails) user;
//}
//}
