package com.trisor.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trisor.user.exception.DataNotFoundException;
import com.trisor.user.model.User;
import com.trisor.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User getUserById(Long userId) {
		return userRepo.findById(userId).orElseThrow(()->new DataNotFoundException(String.format("Given user with id {} not found",userId)));
	}
	
	
	public User createUser(String firstName, String familyName, String email) {
		//TODO: Validation on user existence and user data
		return userRepo.save(User.builder().firstName(firstName).familyName(familyName).email(email).build());
		
	}

}
