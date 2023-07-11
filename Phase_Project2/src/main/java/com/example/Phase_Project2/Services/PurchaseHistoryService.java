package com.example.Phase_Project2.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Phase_Project2.Models.PurchaseHistory;
import com.example.Phase_Project2.Repositories.PurchaseHistoryRepo;

@Service
public class PurchaseHistoryService {

	private final PurchaseHistoryRepo purchaseHistoryRepo;
	
	@Autowired
	public PurchaseHistoryService(PurchaseHistoryRepo purchaseHistoryRepo) {
		this.purchaseHistoryRepo=purchaseHistoryRepo;	
	}
	
	public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        return purchaseHistoryRepo.save(purchaseHistory);
    }
	
	
	 public List<PurchaseHistory> getPurchaseHistoryByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
	        return purchaseHistoryRepo.findByDateBetween(startDate, endDate);
	    }

	public List<PurchaseHistory> getAllPurchaseHistory() {
		return purchaseHistoryRepo.findAll();
	}

	public List<PurchaseHistory> getPurchaseHistoryByCategory(String category) {
        return purchaseHistoryRepo.findByProductCategory(category);
    }
	}
	

