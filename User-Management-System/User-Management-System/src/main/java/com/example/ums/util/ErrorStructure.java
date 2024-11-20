package com.example.ums.util;

import org.springframework.http.HttpStatus;

public class ErrorStructure {

	private  int statusCode;
	private  String message;
	private  String rootCause;
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public String getMessage() {
		return message;
	}
	public String getRootCause() {
		return rootCause;
	}
	
	public static ErrorStructure create(int status,String message,String rootCause) {
		ErrorStructure error=new ErrorStructure();
		error.setStatusCode(status);
		error.setMessage(message);
		error.setRootCause(rootCause);
		return error;
	}
}
