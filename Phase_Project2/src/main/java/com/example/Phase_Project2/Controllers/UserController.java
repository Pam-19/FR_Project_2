package com.example.Phase_Project2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Phase_Project2.Models.User;
import com.example.Phase_Project2.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		return userService.createUser(username, password);	
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		User user = userService.getUserByUsername(username);
		if(user!=null) {
			if( user.getPassword().equals(password)) {
			return "Succesfully Logged In!!";	
		}
		else { 
			return "Invalid Password";		
	}}
		else { 
			return "Invalid Login Details...Try again";
		}
	}
	
}
