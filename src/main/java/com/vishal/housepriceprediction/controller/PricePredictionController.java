package com.vishal.housepriceprediction.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vishal.housepriceprediction.Entity.City;
import com.vishal.housepriceprediction.Entity.UserEntity;
import com.vishal.housepriceprediction.userRepository.CityRepo;
import com.vishal.housepriceprediction.userRepository.StateRepo;
import com.vishal.housepriceprediction.userService.UserService;



@Controller
public class PricePredictionController {

    @Autowired
    private UserService userService;

 

    // Home
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "home";
    }

    // Register Page
    @GetMapping("/registerPage")
    public String registerUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    // Register User
    @PostMapping("/register")
    public String addUserData(@ModelAttribute("user") UserEntity userEntity, Model model) {

        if (userService.findByEmail(userEntity.getEmail()).isPresent()) {
            model.addAttribute("errorMessage", "Email already exists!");
            return "register";
        }

        userService.addUSerData(userEntity);
        return "redirect:/registerPage";
    }

    // Login Page
    @GetMapping("/userLogin")
    public String userLogin(Model model) {
        model.addAttribute("user", new UserEntity());
        return "userLogin";
    }

    // Login
    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserEntity userEntity, Model model) {

        if (userService.findByEmailAndUserPassword(
                userEntity.getEmail(), userEntity.getUserPassword()).isPresent()) {

            return "redirect:/dashboard";  
        }

        model.addAttribute("errorMessage", "Invalid email or password");
        return "userLogin";
    }

   

    
    // fetch all states 
    
    @Autowired
    private StateRepo stateRepo;
    
    @GetMapping("/dashboard")
    public String getAllState(Model model) {
    	
    	model.addAttribute("states",stateRepo.findAll()); 
    	 return "propertyDashbord";
    }
    
    // fetch all citys in dropdown as per this state 
    
    @Autowired
    private CityRepo cityRepo;
    @GetMapping("/getCitiesByState")
    @ResponseBody
    public List<City> getCitiesByState(@RequestParam int stateId) {

        return cityRepo.findByState_StateId(stateId);
    }
    
}