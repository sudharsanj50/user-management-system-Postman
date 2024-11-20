package com.example.ums.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ums.exception.UserNotFoundByUserIdException;
import com.example.ums.exception.UserNotFoundByUsernameException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFound(UserNotFoundByUserIdException ex) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),"User not found by given id"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundByUsername(UserNotFoundByUsernameException ex) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),"User not found by given username"));
	}
}
