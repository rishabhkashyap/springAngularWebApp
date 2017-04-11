package com.blog.service.exceptions;

public class BlogExistException extends RuntimeException {
	public BlogExistException() {
	}

	public BlogExistException(String message) {
		super(message);
	}

	public BlogExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogExistException(Throwable cause) {
		super(cause);
	}

}
