package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;
import com.masai.util.EMUtil;

public class EmployeeDaoImpl implements employeeDao {

	
	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		
	    EntityManager em=EMUtil.provideEntityManager();
	    
	    try {
	    	em.getTransaction().begin();
	 	    
	 	    em.persist(employee);
	 	    
	 	    em.getTransaction().commit();
	 	    
	 	   return employee;
	 	    
	    }catch(Exception e) {
	    	throw new EmployeeException("Employee not registerd...");
	    }finally {
			em.close();
		}
	    
		
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		Employee employee=null;
		
		 EntityManager em=EMUtil.provideEntityManager();
		
		try {
			
		 employee=em.find(Employee.class,empId);
			
			
		} catch (Exception e) {
			throw new EmployeeException("Employee not exist from  employee id : "+empId);
		}finally {
			em.close();
		}
		
		
		
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int empId) throws EmployeeException {
		Employee employee=null;
		
		EntityManager em=EMUtil.provideEntityManager();
		
		
		try {
			
		  employee=em.find(Employee.class,empId);
		  
		  em.getTransaction().begin();
		  
		  em.remove(employee);
		   
		  em.getTransaction().commit();
		  
		} catch (Exception e) {
			throw new EmployeeException("Employee not exist from  employee id : "+empId);
		}finally {
			em.close();
		}
		
		return employee;
		
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		
		 Employee exEmployee=null;
		
	   EntityManager em=EMUtil.provideEntityManager();
	   
		try {
			
			exEmployee=em.find(Employee.class,employee.getEmpid());
			
			if(exEmployee==null) {
				System.out.println("Employee id "+employee.getEmpid()+" dose not exist...");
			}else {
				
				em.getTransaction().begin();
				
				em.merge(employee);
				
				em.getTransaction().commit();
				
				
			}
			
			return exEmployee;
		} catch (Exception e) {
			throw new EmployeeException("Record Not Updated");
		}finally {
			em.close();
		}
		
		
	}

}
