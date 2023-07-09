package com.example.Phase_Project2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Phase_Project2.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}
