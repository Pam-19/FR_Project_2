package com.example.Phase_Project2.Models;
import org.springframework.data.annotation.Id;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@Column(name="Username",nullable=false,unique=true)
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="Password",nullable=false)
    private String password;
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Product { " + " ID : " + id +
				", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
	}

    // Constructors, getters, and setters
}
