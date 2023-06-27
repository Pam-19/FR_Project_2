package com.example.mainApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mainApp.Model.PurchaseHistory;

public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Long>  {

}
