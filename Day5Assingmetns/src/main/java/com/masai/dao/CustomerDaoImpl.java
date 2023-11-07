package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.masai.models.Address;
import com.masai.models.Customer;
import com.masai.utill.EMUtill;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String saveCustomerDetails(Customer customer1, Customer customer2) {
		String msg="Record Not inserted...";
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.persist(customer1);
		
			em.persist(customer2);
			
			em.getTransaction().commit();
			
			msg="Record Inserted SucceFully...";
			
		}finally {
			em.close();
		}
	    	
		return msg;
	}

//*******************************************************************
	
	@Override
	public List<Address> getAllAddressOfCustomerByCid(int cid) {
		
		List<Address> aList=new ArrayList<>();
		
		EntityManager em=EMUtill.provideEntityManager();
		
		try {
			String jpql="SELECT a FROM Customer c INNER JOIN c.addresses a WHERE c.cid = :customerId";
			
		    TypedQuery<Address> tq=em.createQuery(jpql,Address.class);
			
		    tq.setParameter("customerId",cid);
		    
		    aList= tq.getResultList();
		    
		    return aList;
		}finally {
			em.close();
		}
		
		
		
		
	}

}
