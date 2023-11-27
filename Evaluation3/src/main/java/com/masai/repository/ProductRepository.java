package com.masai.repository;

import java.util.List;

import com.masai.bean.Product;

public interface ProductRepository {
	
	public boolean insertProductDetails(Product product);
	
	public List<Product> getAllProductDetails();

	public Product findProduct(int productId);
	
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice);
	
}
