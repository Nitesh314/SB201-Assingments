package com.masai.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.ProductException;
import com.masai.models.Product;
import com.masai.models.ProductDTO;
import com.masai.services.ProductService;

import jakarta.validation.Valid;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping("/products")
	public ResponseEntity<Product>registerProducts(@Valid @RequestBody Product product) throws ProductException{
		
		Product savedProduct= pService.registerProduct(product);
		
		return new ResponseEntity<Product>(savedProduct,HttpStatus.ACCEPTED);
	}
	
//*************************************************************************************************
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>>getAllProducts() throws ProductException{
		
		List<Product> pList= pService.getAllProducts();
		
		return new ResponseEntity<>(pList,HttpStatus.OK);
		
	}
	
//*********************************************************************************************************	
	
	@PutMapping("/products")
	public ResponseEntity<Product>updateProducts(@RequestBody Product product) throws ProductException{
		
		Product p= pService.updateProdcut(product);
		
		return new ResponseEntity<Product>(p,HttpStatus.OK);
		
	}
	
//********************************************************************************************************************
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product>deleteProductById(@PathVariable("productId") Integer pId) throws ProductException{
		
		Product deletedProduct= pService.deleteProductById(pId);
		
		return new ResponseEntity<Product>(deletedProduct,HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	
//********************************************************************************************************************	

	@GetMapping("/products/{stationary}")
	public ResponseEntity<List<Product>>getProductsByCategory(@PathVariable("stationary") String category) throws ProductException{
		
		List<Product>pList= pService.getsProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(pList,HttpStatus.OK);
	}
	
//********************************************************************************************************************
	
	@GetMapping("/productDTO")
	public ResponseEntity<List<ProductDTO>>getProductNameQtyPrice() throws ProductException{
		
		List<ProductDTO> pDTO= pService.getProductNameQtyPrice();
		
		return new ResponseEntity<List<ProductDTO>>(pDTO,HttpStatus.OK);
		
	}
	
	
	
	
}
