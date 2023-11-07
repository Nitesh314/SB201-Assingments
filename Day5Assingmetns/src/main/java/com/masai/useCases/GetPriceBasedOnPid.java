package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;

public class GetPriceBasedOnPid {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Get the Product Price By Entring the Product Id : ");
		int pId=sc.nextInt();
		
		ProductDao pDao=new ProductDaoImpl();
		
	    int p=pDao.getProductPrice(pId);
	    
	    if(p==0) {
	    	System.out.println("Product is Not Available...");
	    }else {
	    	System.out.println("Product Price is : "+p);
	    }
		
	}

}
