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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Transaction_ID")
    private Long transaction_id;
    
    @Column(name="date")
    private LocalDateTime date;
    
   

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Product_Id", referencedColumnName = "id")
    private Product product;
    
//    @Column(name = "product_name")
//    private String productName;
    
//    @Column(name = "category", nullable = false)
//    private String category;
//    public String getCategory() {
//        return product.getCategory();
//    }
  
    
    
    public PurchaseHistory() {
    }
	public PurchaseHistory(Long transaction_id, LocalDateTime date, User user, Product product) {
		super();
		this.transaction_id = transaction_id;
		this.date = date;
		this.user = user;
		this.product = product;
		//this.category = category;
		
	}
	@Override
	public String toString() {
		return "PurchaseHistory [transaction_id=" + transaction_id + ", date=" + date + ", user=" + user + ", product="
				+ product +  "]";
	}
	public Long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
    
    
}
