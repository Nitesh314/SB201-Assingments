package com.masai.dao;

import java.util.List;

import com.masai.models.Product;

public interface ProductDao {
	
	public String  insertProduct(Product p);
	
	//using namedQuery;
	public List<Product> getAllProductNameAndQuantity();
	
	public int getProductPrice(int pId);
	
	public Product getProduct(int pId);
	
	public long getTotalPriceOfAllProducts();
	
	public List<Product> getAllTheProductQuantityLessThanFive();
	

}
