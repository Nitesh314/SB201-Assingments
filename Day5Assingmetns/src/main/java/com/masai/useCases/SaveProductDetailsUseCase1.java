package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.models.Product;

public class SaveProductDetailsUseCase1 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the productId :");
		int id=sc.nextInt();
		
		System.out.print("Enter the product Name :");
		String name=sc.next();
		
		System.out.print("Enter the product price :");
		int price=sc.nextInt();
		
		System.out.print("Enter the product quantity :");
		int quantity=sc.nextInt();
		
		Product p=new Product(id, name, price, quantity);
		
		ProductDao pDao=new ProductDaoImpl();
		
		String res=pDao.insertProduct(p);
		
		System.out.println(res);
		
	}

}
