package com.example.Phase_Project2.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Phase_Project2.Models.Product;
import com.example.Phase_Project2.Models.PurchaseHistory;
import com.example.Phase_Project2.Models.User;
import com.example.Phase_Project2.Services.ProductService;
import com.example.Phase_Project2.Services.PurchaseHistoryService;
import com.example.Phase_Project2.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
    private final PurchaseHistoryService purchaseHistoryService;
    private final ProductService productService;

	@Autowired
	public UserController(UserService userService,PurchaseHistoryService purchaseHistoryService,ProductService productService) {
		this.userService=userService;
		this.purchaseHistoryService = purchaseHistoryService;
		this.productService=productService;
	}
	
	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		return userService.createUser(username, password);	
	}
	
	@PostMapping("/purchase-history")
	public PurchaseHistory createPurchaseHistory(@RequestBody PurchaseHistory purchaseHistory) {
//	    // Set the date and time of the purchase
//	    purchaseHistory.setDate(LocalDateTime.now());

	    // Save the PurchaseHistory object
	    return purchaseHistoryService.savePurchaseHistory(purchaseHistory);
	}
	
	

	
	@DeleteMapping
    public String deleteUser(@RequestParam String username, @RequestParam String password) {
		User user = userService.getUserByUsername(username);
		if(user!=null) {
			if( user.getPassword().equals(password)) {
				userService.deleteUserByName(username);
				return "Succesfully Deleted";
		}
		else { 
			return "Invalid Password";		
	}
			}
		else {
			return "No such User exists";
		}
        
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
