package com.vishal.housepriceprediction.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.housepriceprediction.Entity.City;

public interface CityRepo extends JpaRepository<City , Integer>{
	List <City> findByState_StateId(int stateId);
}
