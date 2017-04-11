package com.blog.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import com.blog.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResource extends ResourceSupport {
	
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	public Account toAccount(){
		Account account=new Account();
		account.setusername(this.username);
		account.setPassword(this.password);
		return account;
		
		
	}
	

}
