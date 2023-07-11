package com.example.Phase_Project2.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Phase_Project2.Models.Product;
//import com.example.Phase_Project2.Models.User;
import com.example.Phase_Project2.Services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        try{productService.deleteProduct(id);
        return"Successfully Deleted";
        }
        catch(Exception e) {
        	return "Could not delete";
        }
    }
    
    @PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if(username.equals("Admin")) {
			if( password.equals("AdminPassword")) {
			return "Welcome Admin!!!";	
		}
		else { 
			return "Invalid Password";		
	}}
		else { 
			return "Invalid Admin Login Details...Try again";
		}
	}
}