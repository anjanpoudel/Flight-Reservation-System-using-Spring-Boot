package com.anjan.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anjan.flightreservation.entities.Users;
import com.anjan.flightreservation.repos.UserRepository;
import com.anjan.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private BCryptPasswordEncoder encoder; 
	
	@Autowired
	private SecurityService securityService; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("/showReg")
	public String showRegistrationPage() 
	{
		LOGGER.info("Inside showRegistration Page ...");
		return "login/registerUser"; 
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") Users user) 
	{
		LOGGER.info("Inside register " + user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() 
	{
		LOGGER.info("Inside showLogin Page ...");
		return "login/login"; 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String Login(@RequestParam("email") String email,
				@RequestParam("password") String password, ModelMap modelMap ) 
	{
		
		LOGGER.info("Inside Login() and email is " + email);
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) 
		{
			return "findFlights";
		}
		else 
		{
			modelMap.addAttribute("msg", "Invalid user name or Password. Please try again..");
		}
		
		return "login/login";
	}
}
