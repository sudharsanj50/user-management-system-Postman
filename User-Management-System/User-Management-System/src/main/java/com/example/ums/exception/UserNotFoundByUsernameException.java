package com.example.ums.exception;

public class UserNotFoundByUsernameException extends BaseException{

	
	private final String message;


	public UserNotFoundByUsernameException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
	

	
	
}
