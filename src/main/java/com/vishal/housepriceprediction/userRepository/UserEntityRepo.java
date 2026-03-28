package com.vishal.housepriceprediction.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishal.housepriceprediction.UserEntity.UserEntity;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Integer>{
	Optional <UserEntity> findByEmail(String email);
	
	Optional <UserEntity> findByEmailAndUserPassword(String email,String userPassword);
}
