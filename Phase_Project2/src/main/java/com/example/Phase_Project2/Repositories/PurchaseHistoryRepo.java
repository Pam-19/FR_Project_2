package com.example.Phase_Project2.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Phase_Project2.Models.PurchaseHistory;

@Repository
public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory,Long>{
	 List<PurchaseHistory> findByCategory(String category);
	    
	    List<PurchaseHistory> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
