package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.ProductException;
import com.masai.bean.Product;
import com.masai.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pr;

	@Override
	public boolean addProduct(Product product) {
		boolean flag=false;
		
		if(pr.insertProductDetails(product)) {
			flag=true;
			return flag;
		}else {
		   return flag;
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> pList=new ArrayList<>();
		
		pList= pr.getAllProductDetails();
		
		return pList;
		
	}

	@Override
	public Product getProductById(int productId) throws ProductException {
		Product product=null;
		
		product= pr.findProduct(productId);
		
		if(product==null) {
			throw new ProductException("Product Id  "+productId+"dose not exist...");
		}
		
		return product;
	}

	@Override
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException {
		List<Product> pList=new ArrayList<>();
		
		pList= pr.getProductInPriceRange(fromPrice, toPrice);
		
		if(pList.isEmpty()) {
			throw new ProductException("Product is not available between "+fromPrice+" to "+toPrice+" price ");
		}
		
		return pList;
		
	}

}
