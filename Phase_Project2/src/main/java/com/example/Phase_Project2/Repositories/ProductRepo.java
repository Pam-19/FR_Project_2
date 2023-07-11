package com.example.Phase_Project2.Repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Phase_Project2.Models.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	List<Product> findByCategory(String category);
}
