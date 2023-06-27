package com.example.mainApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mainApp.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
