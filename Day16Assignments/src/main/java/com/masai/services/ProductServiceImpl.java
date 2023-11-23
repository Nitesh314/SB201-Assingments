package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.ProductException;
import com.masai.models.Product;
import com.masai.models.ProductDTO;
import com.masai.repositorys.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo pRepo;
	

	@Override
	public Product registerProduct(Product p) throws ProductException {
		
		Product savedProduct= pRepo.save(p);
		
		if(savedProduct.getProductId()<=0) {
			throw new ProductException("Student record not saved...");
		}else {
			return savedProduct;
		}
		
			
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> allProducts= pRepo.findAll();
		
		if(allProducts.isEmpty()) {
			throw new ProductException("Product not available...");
		}else {
			return allProducts;
		}
		
		
	}
	
	
	

	@Override
	public Product updateProdcut(Product p) throws ProductException {
		
		Product product= pRepo.findById(p.getProductId()).orElseThrow(()-> new ProductException("Product not updated..."));
		
		    Product p1= pRepo.save(product);
		
		    return p1;
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		
		Product p= pRepo.findById(pid).orElseThrow(()-> new ProductException("Product not found with id : "+pid));
		
	        pRepo.delete(p);
	        
	        return p;
		
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		     
		List<Product> pList= pRepo.findProductByCategory(category);
		
		if(pList.isEmpty()) {
			throw new ProductException("Product not found with category name : "+category);
		}else {
		return pList;
		}
		
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		
		
		List<ProductDTO> pDTO= pRepo.getProductNameQtyAndPrice();
		
		if(pDTO.isEmpty()) {
			throw new ProductException("Product not found...");
			
		}else {
			return pDTO;
		}
		
		
	}

}
