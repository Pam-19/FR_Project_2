package com.example.Phase_Project2.Models;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "product")
public class Product {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Category", nullable = false)
    private String category;

    @Column(name = "Price", nullable = false)
    private double price;

    
    public Product() {
    	super();
    }
    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }
	    
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Long getId() { //marking this column as the primary key
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			//to make it case insensitive
			String cat = category.toUpperCase();
			cat.trim();
			this.category = cat;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		@Override
	    public String toString() {
	        return "Product{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", category='" + category + '\'' +
	                '}';
	    }
}
