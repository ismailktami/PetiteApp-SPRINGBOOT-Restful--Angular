package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	@Id
	private String username;
	private String password;
	private boolean actived;
	public boolean isActived() {
		return actived;
	}


	public void setActived(boolean actived) {
		this.actived = actived;
	}


	public User(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}


	@ManyToMany
	@JoinTable(name="users_roles")
	private Collection<Role> roles;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	
	
	
}
