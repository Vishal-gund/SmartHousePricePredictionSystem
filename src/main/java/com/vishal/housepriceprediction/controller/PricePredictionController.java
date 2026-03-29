package com.vishal.housepriceprediction.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vishal.housepriceprediction.UserEntity.UserEntity;
import com.vishal.housepriceprediction.userService.UserService;


@Controller
public class PricePredictionController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/" , "/home"})
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/registerPage") // getFrom page
	public String registerUser(Model model) {
		model.addAttribute("user",new UserEntity());
		return "register";
	}
	

	@PostMapping("/register")
	public String addUserData(@ModelAttribute("user") UserEntity userEntity , Model model) {
		if(userService.findByEmail(userEntity.getEmail()).isPresent()) {
			model.addAttribute("errorMessage", "Enter valid email(duplicates)");
			return "register";
		}
		
		userService.addUSerData(userEntity);
		return "redirect:/registerPage";
	}
	
	
	
	@GetMapping("/userLogin")
	public String userLogin(Model model) {
		model.addAttribute("user", new UserEntity());
		return "userLogin";
	}
	
	@PostMapping("/login")
	public String userPropertyManagementDashboard(@ModelAttribute("user") UserEntity userEntity,Model model) {
		if(userService.findByEmailAndUserPassword(userEntity.getEmail(), userEntity.getUserPassword()).isPresent()) {
			return "propertyDashbord";
		}
		
		model.addAttribute("errorMessage", "Enter valid email and password");
		return "userLogin";
		
	}
}
