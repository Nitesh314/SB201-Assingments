package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.masai.models.Address;
import com.masai.models.Customer;
import com.masai.utility.EMUtil;

public class CustomerAddressDaoImpl implements CustomerAddressDao {

	@Override
	public String insertCustomerAddressDetails(Customer c1, Customer c2) {
		String msg="Details not insertde....";
		
	 	EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(c1);
			em.persist(c2);
			
			em.getTransaction().commit();
			
		return	msg="Details inserted successfully....";
			
		}finally {
			em.close();
		}
	}
//*************************************************************************************************************
	
	@Override
	public List<Address> getCustomerAddressesBasedOnCid(int cid) {
		
		List<Address>aList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT a from Customer c INNER JOIN c.addresses a where c.cid=:cid";
			
		    TypedQuery<Address> tq=em.createQuery(jpql,Address.class);
			
		    tq.setParameter("cid",cid);
		    
		     aList=tq.getResultList();			
		     
			 return aList;
			
		}finally {
			em.close();
		}
		
		
	}

}
