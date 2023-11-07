package com.masai.useCases;

import java.util.List;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.models.Product;

public class GetAllProductNameAndQuantitys {
	
	public static void main(String[] args) {
		
		ProductDao pDao=new ProductDaoImpl();
		
		List<Product> pList= pDao.getAllProductNameAndQuantity();
		
        if(pList.isEmpty()) {
        	System.out.println("Product list is Empty...");
        }
        else {
        	 pList.forEach(p->System.out.println("Product Name : "+p.getProductName()+"\nProduct Quantity : "+p.getQuantity()+"\n*********************************"));
        }
		
		
	}

}
