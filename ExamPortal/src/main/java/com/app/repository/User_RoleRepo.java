package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Role;
import com.app.model.User_Role;
import com.app.model.User;

public interface User_RoleRepo extends JpaRepository<User_Role, Integer>
{
	@Query("select u from User_Role u where u.user = :user and u.role = :role")
	public User_Role getByUAndR(@Param("user") User user,@Param("role") Role role);
}
