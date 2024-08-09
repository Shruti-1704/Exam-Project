package com.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int rid;
	@Column
	private String rolename;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role")
	private List<User_Role> user_roles;

	public Role() {
		super();
	}

	public Role(int rid, String rolename) {
		super();
		this.rid = rid;
		this.rolename = rolename;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<User_Role> getUser_roles() {
		return user_roles;
	}

	public void setUser_roles(List<User_Role> user_roles) {
		this.user_roles = user_roles;
	}
	
	
}
