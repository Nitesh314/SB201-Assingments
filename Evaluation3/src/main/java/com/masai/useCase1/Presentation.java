package com.masai.useCase1;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import com.masai.Exception.ProductException;
import com.masai.bean.AppConfig;
import com.masai.bean.Product;
import com.masai.service.ProductService;

@Controller
public class Presentation {
	

    Scanner sc=new Scanner(System.in);
 
	
	@Autowired
	private ProductService ps;//dependency
	
	public void insertProduct() {
		
		System.out.print("Enter the product name : ");
		String pName= sc.next();
		
		System.out.print("Enter the product quantity : ");
		int quantity= sc.nextInt();
		
		System.out.print("Enter the product price : ");
		int price= sc.nextInt();
		
		Product pr=new Product();
		pr.setProductName(pName);
		pr.setQuantity(quantity);
		pr.setPrice(price);
		
		boolean f= ps.addProduct(pr);
		
		if(f) {
			System.out.println("Product details Added successfully...");
		}else {
			System.out.println("product details not added...");
		}
		
	}
	
//*******************************************************************************************************************************	
	
	
	public void printAllProduct(){
		
		List<Product> pList= ps.getAllProducts();
		
		if(pList.isEmpty()) {
			System.out.println("No Product Available...");
		}else {
			pList.forEach(p->System.out.println("Product ID : "+p.getProductId()+"\nProduct Name : "+p.getProductName()+"\nProduct Quantity : "+p.getQuantity()+"\nProduct Price : "+p.getPrice()+"\n************************************"));
		}
		
	}

//*******************************************************************************************************************************************
	
	public void searchProduct(){
		
		System.out.print("Enter the product Id : ");
		int productId=sc.nextInt();
		
		try {
			Product p= ps.getProductById(productId);
			
			System.out.println("Product ID : "+p.getProductId()+"\nProduct Name : "+p.getProductName()+"\nProduct Quantity : "+p.getQuantity()+"\nProduct Price : "+p.getPrice()+"\n************************************");
					
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
//******************************************************************************************************************************************************************************************************		
	public void GetProductsWithingPriceRange(){
		
		System.out.print("Enter the product price from  ");
		int priceFrom=sc.nextInt();
				
	    System.out.print("Enter the product price to : ");
		int priceTo=sc.nextInt();
		
		try {
			List<Product> pList= ps.getProductsBetweenPrice(priceFrom, priceTo);
			
			pList.forEach(p->System.out.println("Product ID : "+p.getProductId()+"\nProduct Name : "+p.getProductName()+"\nProduct Quantity : "+p.getQuantity()+"\nProduct Price : "+p.getPrice()+"\n************************************"));
			
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
			
			
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Presentation pr= ctx.getBean(Presentation.class);
		
	     
	     
	   
	     while(true) {
	    	 
	    	 System.out.println("1 Add Products"+"\n2 Get All Products"+"\n3 Get Product By Id "+"\n4 Get Product Between price "+"\n5 Exist the app ");
		     
		     int choice=sc.nextInt();
	    	 
	    	  switch (choice) {
	  		case 1:{
	  			pr.insertProduct();
	  			break;
	  		}
	  		case 2:{
	  			pr.printAllProduct();
	  			break;
	  		}
	  		case 3:{
	  			pr.searchProduct();
	  			break;
	  		}
	  		case 4:{
	  			pr.GetProductsWithingPriceRange();
	  			break;
	  		}
	  		case 5:{
	  			System.out.println("Thakyou...");
	  			System.exit(0);
	  		}
	  		default: {
	            System.out.println("Invalid choice. Please choose a valid option.");
	        }
	  	  }
	    	 
	     }
	   
	}

}
