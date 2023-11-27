package com.masai.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.masai.bean.Product;
import com.masai.utility.EMUtil;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public boolean insertProductDetails(Product product) {
		
		boolean flag=false;
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.persist(product);
            
			em.getTransaction().commit();
			
			flag=true;
			
		}finally {
			em.close();
		}
		
		
		
		return flag;
	}

	@Override
	public List<Product> getAllProductDetails() {
		
		List<Product> pList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
		   
			 TypedQuery<Product> tq= em.createQuery("from Product",Product.class);
			
			 pList= tq.getResultList();
			 
			 return pList;
			
			
		}finally {
			em.close();
		}
		
	}

	@Override
	public Product findProduct(int productId) {
		
		Product product=null;
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			product= em.find(Product.class,productId);
			
			return product;
			
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice) {
		
		List<Product> pList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT p FROM Product p WHERE p.price >= :fromPrice AND p.price < :toPrice";

			TypedQuery<Product> tq= em.createQuery(jpql,Product.class);
			
			tq.setParameter("fromPrice",fromPrice);
			tq.setParameter("toPrice",toPrice);
			
			pList= tq.getResultList();
			
			return pList;
			
		}finally {
			em.close();
		}
		
	}

}
