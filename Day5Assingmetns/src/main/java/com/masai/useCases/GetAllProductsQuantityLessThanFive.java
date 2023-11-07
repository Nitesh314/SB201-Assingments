package com.masai.useCases;

import java.util.List;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.models.Product;

public class GetAllProductsQuantityLessThanFive {
	
	public static void main(String[] args) {
		
		
		ProductDao pDao=new ProductDaoImpl();
		
		List<Product> pList= pDao.getAllTheProductQuantityLessThanFive();
		
		if(pList.isEmpty()) {
			System.out.println("No Product available..");
		}
		else {
			pList.forEach(p->System.out.println("Product Id : "+p.getProductId()+"\nProduct Name : "+p.getProductName()+"\nProduct Price : "+p.getPrice()+"\nProduct Quantity : "+p.getQuantity()+"\n*******************************"));
		}
		
		
	}

}
