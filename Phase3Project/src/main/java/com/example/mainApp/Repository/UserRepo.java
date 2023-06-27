package com.example.mainApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mainApp.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
