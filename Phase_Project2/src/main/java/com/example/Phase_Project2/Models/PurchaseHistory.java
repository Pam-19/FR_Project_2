package com.example.Phase_Project2.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Purchase_History")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Transaction_ID")
    private Long transaction_id;
    
    @Column(name="date")
    private LocalDateTime date;
    
   

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Product_Id", referencedColumnName = "id")
    private Product product;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;
    
    
    public PurchaseHistory() {
    }
	public PurchaseHistory(Long transaction_id, LocalDateTime date, User user, Product product, String productName,
			String category, double price) {
		super();
		this.transaction_id = transaction_id;
		this.date = date;
		this.user = user;
		this.product = product;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
	@Override
	public String toString() {
		return "PurchaseHistory [transaction_id=" + transaction_id + ", date=" + date + ", user=" + user + ", product="
				+ product + ", productName=" + productName + ", category=" + category + ", price=" + price + "]";
	}
    
    
}
