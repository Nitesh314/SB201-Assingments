package com.masai.models;

import java.util.jar.Attributes.Name;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Product.getAllNameAndQuantity",
        query = "SELECT p.productName, p.quantity FROM Product p"
    ),
    @NamedQuery(
        name = "Product.getAllPrice",
        query = "SELECT p.price FROM Product p WHERE p.productId = :pId"
    ),
})
public class Product {
	@Id
	private int productId;
	private String productName;
	private int price;
	private int quantity;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(int productId, String productName, int price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
