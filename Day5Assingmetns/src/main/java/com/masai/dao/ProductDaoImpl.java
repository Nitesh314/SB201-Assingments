package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.masai.models.Product;
import com.masai.utill.EMUtill;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String insertProduct(Product p) {
		
		String msg="Product Not Inserted...";
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(p);
			
			em.getTransaction().commit();
			
			msg="Product Inserted SuccessFully";
			
			
		}finally {
			em.close();
		}
		
		
		
		return msg;
	}
//************************************************************************
	//using namedQuery
	
	@Override
	public List<Product> getAllProductNameAndQuantity() {
		List<Product> pList=new ArrayList<>();
		
	    EntityManager em=EMUtill.provideEntityManager();
	    
	    try {
	    	Query q=em.createNamedQuery("Product.getAllNameAndQuantity");
			
		   List<Object[]> qList= q.getResultList();
		   
		   for(Object[] or : qList) {
			   
			 String productName  =(String)or[0];
			 
			 Integer quantity=(Integer)or[1];
			 
			    Product product = new Product();
			    product.setProductName(productName);
			    product.setQuantity(quantity);
			    
			    pList.add(product);
			   
		   }
		    
		    return pList;

		    
	    }finally {
			em.close();
		}
	   
			}

//*********************************************************************************	
	
	@Override
	public int getProductPrice(int pId) {
		
		int i=0;
		
	    EntityManager em=EMUtill.provideEntityManager();
		
	    try {
	    	
	      Query q=em.createNamedQuery("Product.getAllPrice");
	    
	      q.setParameter("pId",pId);
	      
	      q.getSingleResult();
	        
	      Object result= q.getSingleResult();
	      
	      if(result!=null && result instanceof Integer) {
	    	  i=(Integer)result;
	    	  
	    	  return i;
	      }
	      else {
	    	  return i;
	      }
	    	
	    	
	    }finally {
			em.close();
		}
		
	}
//***********************************************************************
	
	@Override
	public Product getProduct(int pId) {
		Product pro=null;
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			
			String jpql="SELECT p from Product p where p.productId=:pId";
			
			TypedQuery<Product> tq=em.createQuery(jpql,Product.class);
			
			tq.setParameter("pId",pId);
			
			pro=tq.getSingleResult();
			
			return pro;
			
		}finally {
			em.close();
		}
		 
	}
//******************************************************************
	
	@Override
	public long getTotalPriceOfAllProducts() {
		long totalPrice=0;
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			String jpql="SELECT sum(price*quantity) from Product";
			
			TypedQuery<Long> tq= em.createQuery(jpql,Long.class);
			
			return totalPrice=tq.getSingleResult();
			
		}finally {
			em.close();
		}
		
	}
//****************************************************************************
	@Override
	public List<Product> getAllTheProductQuantityLessThanFive() {
		
		List<Product> pList=new ArrayList<>();
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			
			String jpql="SELECT p FROM Product p WHERE p.quantity < 20";
			
			Query q=em.createQuery(jpql);
			
		    return pList=q.getResultList();
		    
		}finally {
			em.close();
		}
		
	}

}
