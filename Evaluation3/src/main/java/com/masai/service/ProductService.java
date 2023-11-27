package com.masai.service;

import java.util.List;

import com.masai.Exception.ProductException;
import com.masai.bean.Product;

public interface ProductService {
	
	public boolean addProduct(Product product);
	
	public List<Product> getAllProducts();

	public Product getProductById(int productId)throws ProductException;
	
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice)throws ProductException;
}
