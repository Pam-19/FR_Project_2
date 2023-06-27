package com.example.mainApp.AdminController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.mainApp.Model.Product;
import com.example.mainApp.Model.PurchaseHistory;
import com.example.mainApp.Model.User;
import com.example.mainApp.Repository.ProductRepo;
import com.example.mainApp.Repository.PurchaseHistoryRepo;
import com.example.mainApp.Repository.UserRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {

   private final UserRepo userRepository;
   private final ProductRepo productRepository;
   private final PurchaseHistoryRepo purchaseHistoryRepository;

   @Autowired
   public AdminController(UserRepo userRepository, ProductRepo productRepository,
                          PurchaseHistoryRepo purchaseHistoryRepository) {
       this.userRepository = userRepository;
       this.productRepository = productRepository;
       this.purchaseHistoryRepository = purchaseHistoryRepository;
   }

   @PostMapping("/change-password")
   public String changePassword(@RequestParam String newPassword) {
       // Code
       return "Password changed successfully";
   }

}

//
//public class AdminController {
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
