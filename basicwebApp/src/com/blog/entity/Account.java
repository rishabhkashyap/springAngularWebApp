package com.blog.entity;


//This entity class stores data of user's account

public class Account {
	private Long id;
	private String username;
	private String password;
	
	//Getter and setter for above fields
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
