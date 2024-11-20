package com.example.ums.exception;

public class UserNotFoundByUserIdException extends RuntimeException {

	private final String message;

	public String getMessage() {
		return message;
	}

	public UserNotFoundByUserIdException(String message) {
		super();
		this.message = message;
	}

	
	
}
