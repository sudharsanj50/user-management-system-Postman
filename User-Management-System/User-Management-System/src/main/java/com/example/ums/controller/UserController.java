package com.example.ums.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ums.entity.User;
import com.example.ums.exception.UserNotFoundByUserIdException;
import com.example.ums.service.UserService;
import com.example.ums.util.ResponseStructure;

// @RestController is combination of @ResponseBody and @Controller
@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/save-user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "user created",userService.saveUser(user)));
	}
	
	@GetMapping("/find-user")
	public ResponseEntity<User> findUserById(@RequestParam int userId) 
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserById(userId));
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<User> deleteUser(@RequestParam int userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body( userService.updateUser(user));
	}
	
	@GetMapping("/find-user-by-username")
	public ResponseEntity<ResponseStructure<Object>> findUserByUsername(@RequestParam String username){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "user created",userService.findUserByUsername(username)));
	}
}
