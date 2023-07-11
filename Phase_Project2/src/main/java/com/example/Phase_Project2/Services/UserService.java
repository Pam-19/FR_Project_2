package com.example.Phase_Project2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Phase_Project2.Models.User;
import com.example.Phase_Project2.Repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return userRepository.save(user);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);	
	}
	public void deleteByUserId(Long Id) {
		userRepository.deleteById(Id);
	}
	public void deleteUserByName(String username) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			userRepository.delete(user);
		}
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	
}
