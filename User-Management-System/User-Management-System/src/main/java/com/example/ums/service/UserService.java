package com.example.ums.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ums.entity.User;
import com.example.ums.exception.BaseException;
import com.example.ums.exception.UserNotFoundByUserIdException;
import com.example.ums.exception.UserNotFoundByUsernameException;
import com.example.ums.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public User findUserById(int userId)  {

		return userRepository.findById(userId).orElseThrow(()->new UserNotFoundByUserIdException("User not found"));
	}

	public User deleteUser(int userId)  {
		return userRepository.findById(userId).map(user ->{
			userRepository.delete(user);
			return user;
		}).orElseThrow(()-> new UserNotFoundByUserIdException("User not found"));
	}

	public User updateUser(User user)  {

		//		return userRepository.findById(user.getUserId()).map(userRepository::save).orElseThrow();
		Optional<User> optional=userRepository.findById(user.getUserId());

		if(optional.isPresent()) {
			return userRepository.save(user);
		}else {
			throw new UserNotFoundByUserIdException("User not found ");
		}
	}

	public Object findUserByUsername(String username) {
		return userRepository.findUserByUsername(username).orElseThrow(()->new UserNotFoundByUsernameException("user not found"));
	}

}
