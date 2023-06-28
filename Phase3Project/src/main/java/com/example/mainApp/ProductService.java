package com.example.mainApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	 private final ProductRepo productRepository;
	 
	    @Autowired
	    public ProductService(ProductRepo productRepository) {
	        this.productRepository = productRepository;
	    }

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Long id, Product updatedProduct) {
	        Optional<Product> existingProduct = productRepository.findById(id);
	        if (existingProduct.isPresent()) {
	            updatedProduct.setId(id);
	            return productRepository.save(updatedProduct);
	        }
	        throw new IllegalArgumentException("Product not found with id: " + id);
	    }

	    public void deleteProduct(Long id) {
	        Optional<Product> product = productRepository.findById(id);
	        if (product.isPresent()) {
	            productRepository.delete(product.get());
	        } else {
	            throw new IllegalArgumentException("Product not found with id: " + id);
	        }
	    }
	}
