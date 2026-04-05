package com.vishal.housepriceprediction.userService;




import java.util.Optional;

import com.vishal.housepriceprediction.Entity.UserEntity;

public interface UserService {
	public UserEntity addUSerData(UserEntity user);
	
	Optional <UserEntity> findByEmail(String email);
	Optional <UserEntity> findByEmailAndUserPassword(String email,String userPassword);
	

}
