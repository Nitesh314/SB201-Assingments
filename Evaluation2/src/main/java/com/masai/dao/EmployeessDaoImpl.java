package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.masai.models.ContractualEmployee;
import com.masai.models.SalariedEmployee;
import com.masai.utillity.EMUtil;

public class EmployeessDaoImpl implements EmployeessDao {

	@Override
	public String addSalariedEmployee(SalariedEmployee se) {
		String msg="not inserted...";
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(se);
			
			em.getTransaction().commit();
			
			msg="Salaried Employee details inserted successfully...";
			return msg;
			
		}finally {
			em.close();
		}
		
	}
//************************************************************************
	@Override
	public String addContractualEmployee(ContractualEmployee ce) {
        String msg="not inserted...";
        
        EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(ce);
			
			em.getTransaction().commit();
			
			msg="Contractual Employee details inserted successfully...";
			
			return msg;
			
		}finally {
			em.close();
		}
	}

//*******************************************************************************************	
	
	@Override
	public List<SalariedEmployee> getSalariedEmployeesDetails() {
		List<SalariedEmployee> seList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT se from SalariedEmployee se ";
			
			TypedQuery<SalariedEmployee> tq= em.createQuery(jpql,SalariedEmployee.class);
			
			seList= tq.getResultList();
			
			return seList;
			
		}finally {
			em.close();
		}
		
	}
	
//*******************************************************************************************
	@Override
	public List<ContractualEmployee> getContractualEmployeesDetails() {
        List<ContractualEmployee> ceList=new ArrayList<>();

        EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT ce from ContractualEmployee ce ";
			
			TypedQuery<ContractualEmployee> tq= em.createQuery(jpql,ContractualEmployee.class);
			
			ceList= tq.getResultList();
			
			return ceList;
			
		}finally {
			em.close();
		}
	}

}
