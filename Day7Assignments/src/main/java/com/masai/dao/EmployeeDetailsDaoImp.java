package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.model.Employee;
import com.masai.utility.EMUtil;

public class EmployeeDetailsDaoImp implements EmployeeDetailsDao {

	@Override
	public String insertEmployeeDetails(Employee emp) {
		String msg="Not inserted...";
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(emp);
			
			em.getTransaction().commit();
			
			msg="Details inserted successfully...";
			
			return msg;
			
		}finally {
			em.close();
		}
		
	}
	
	

}
