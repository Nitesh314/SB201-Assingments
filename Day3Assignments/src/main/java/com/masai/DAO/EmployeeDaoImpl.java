package com.masai.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.Entites.Employee;


public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public void save(Employee emp) {
		
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("employeeUnit");
	  
	  EntityManager em=emf.createEntityManager();
	      
	      em.getTransaction().begin();
		  em.persist(emp);
		  em.getTransaction().commit();
		  
		  System.out.println("Employee details save successfully...");
	  
		  
		
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		
		String msg="addrress not found...";
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employeeUnit");
		  
		EntityManager em=emf.createEntityManager();
		
		
	   Employee emp=em.find(Employee.class, empId);
	   
	   if(emp!=null) {
		   msg=("Employee name : "+emp.getName()+"\nEmployee Address : "+emp.getAddress()+"\n");
		   return msg;
	   }else {
		   return msg; 
	   }
	   
	   
		 
	  
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		String msg="Bonus are not available";
		
		
	       
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employeeUnit");
		  
		EntityManager em=emf.createEntityManager();
		
		
	    Employee emp=em.find(Employee.class, empId);
	    
	    if(emp!=null) {
	    	
	    	em.getTransaction().begin();
	    	
	    	emp.setSalary(emp.getSalary());

	    	em.getTransaction().commit();
	    	
	    	msg=(emp.getName()+" Bonus is : "+bonus+"\n"+"Total salary with bonus : "+emp.getSalary()+bonus);
	    	return msg;
	    }
	    else
		
		return msg;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		boolean flag=false;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employeeUnit");
		  
		EntityManager em=emf.createEntityManager();
		
		Employee emp=em.find(Employee.class, empId);
		
		if(emp!=null) {
			
			flag=true;
			
			em.getTransaction().begin();
			
			em.remove(emp);
			
			em.getTransaction().commit();
			
			
		}
	    return flag;
	}

}
