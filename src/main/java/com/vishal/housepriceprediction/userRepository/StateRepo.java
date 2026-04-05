package com.vishal.housepriceprediction.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.housepriceprediction.Entity.State;

public interface StateRepo extends JpaRepository< State , Integer>{

}
