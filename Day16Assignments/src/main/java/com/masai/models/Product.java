package com.masai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
    @NotNull(message = "productName must be mandatory...")
	private String productName;
    @Min(value=10,message = "quantity should be greater than equal to 10...")
	private Integer quantity;
    @Max(value=1000,message = "price should we less than and equal to  1000...")
	private Double price;
    
    
	private String category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, Integer quantity, Double price, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
    
}
