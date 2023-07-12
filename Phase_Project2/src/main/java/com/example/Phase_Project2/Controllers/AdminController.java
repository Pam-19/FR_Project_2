package com.example.Phase_Project2.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Phase_Project2.Models.Product;
import com.example.Phase_Project2.Models.PurchaseHistory;
import com.example.Phase_Project2.Models.User;
//import com.example.Phase_Project2.Models.User;
import com.example.Phase_Project2.Services.ProductService;
import com.example.Phase_Project2.Services.PurchaseHistoryService;
import com.example.Phase_Project2.Services.UserService;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
	StringBuilder passkey= new StringBuilder("AdminPassword");
    private final ProductService productService;
    private final PurchaseHistoryService purchaseHistoryService;
    private final UserService userService;
    
    @Autowired
    public AdminController(ProductService productService,PurchaseHistoryService purchaseHistoryService,UserService userService) {
        this.productService = productService;
		this.purchaseHistoryService = purchaseHistoryService;
		this.userService = userService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/users")
    public List<User> getAllUSers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/products/{id}")
//    public Optional<Product> getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    } Removed due to ID and Category conflict, Category was prioritized
    
    @GetMapping("/products/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
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
        	return "Could not delete...";
        }
    }
    @GetMapping("/purchase-history")
    public List<PurchaseHistory> getAllPurchaseHistory() {
        return purchaseHistoryService.getAllPurchaseHistory();
    }
    
    @GetMapping("/purchase-history/{category}")
    public List<PurchaseHistory> getPurchaseHistoryByCategory(@PathVariable String category) {
        return purchaseHistoryService.getPurchaseHistoryByCategory(category);
    }
    @GetMapping("/purchase-history/date-range")
    public List<PurchaseHistory> getPurchaseHistoryByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return purchaseHistoryService.getPurchaseHistoryByDateRange(startDate, endDate);
    }

    
    @PutMapping("/password")
    public String changePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
    		if (passkey.toString().equals(oldPassword)) {
            passkey= new StringBuilder(newPassword);
            return "Password changed successfully.";
        }
        
        return "Failed to change password";
    }
    @PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if(username.equals("Admin")) {
			if( password.equals(passkey.toString())) {
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