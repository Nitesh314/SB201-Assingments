package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.models.Product;

public class GetProductBasedOnPid {

	public static void main(String[] args) {
       
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Get the Product Price By Entring the Product Id : ");
		int pId=sc.nextInt();
		
		
		ProductDao pDao=new ProductDaoImpl();
		
		Product p= pDao.getProduct(pId);
		
		if(p==null) {
			System.out.println("Product is not available...");
		}else{
	      System.out.println("Product ID : "+p.getProductId()+"\nProduct Name : "+p.getProductName()+"\nProduct Price : "+p.getPrice()+"\nProduct Quantity : "+p.getQuantity());
		}
		
	}

}
