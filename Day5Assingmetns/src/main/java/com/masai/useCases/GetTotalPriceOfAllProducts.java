package com.masai.useCases;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;

public class GetTotalPriceOfAllProducts {

	public static void main(String[] args) {
		
		ProductDao pDao=new ProductDaoImpl();
		
		long result=pDao.getTotalPriceOfAllProducts();
		
		if(result<=0) {
			System.out.println("NO Product...");
		}else {
			System.out.println("Total Price of All Products : "+result);
		}
		
		
		
		
	}

}
