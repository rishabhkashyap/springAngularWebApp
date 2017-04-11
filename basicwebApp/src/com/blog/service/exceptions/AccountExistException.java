package com.blog.service.exceptions;

public class AccountExistException extends RuntimeException {
	
	public AccountExistException(String message){
		super(message);
	}
	public AccountExistException(){
		super();
	}
	public AccountExistException(String message,Throwable cause){
		super(message,cause);
		
	}

}
