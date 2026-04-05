package com.vishal.housepriceprediction.userService;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishal.housepriceprediction.Entity.UserEntity;
import com.vishal.housepriceprediction.userRepository.UserEntityRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserEntityRepo userRepo;

	@Override
	public UserEntity addUSerData(UserEntity user) {
		UserEntity savedUser = userRepo.save(user);
		
		if (savedUser == null) {
	        throw new RuntimeException("User not saved");
	    }

	    return savedUser;
	}
	
	
	
// avoid duplicate user registration
	@Override
	public Optional<UserEntity> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}



	
	// find out perfect user 
	@Override
	public Optional<UserEntity> findByEmailAndUserPassword(String email, String userPassword) {
		return userRepo.findByEmailAndUserPassword(email, userPassword);
	}
	

}
