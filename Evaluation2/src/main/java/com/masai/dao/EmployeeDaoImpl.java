package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.models.Department;
import com.masai.models.Employee;
import com.masai.utillity.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void addDepartment(Department dpt) {
		
	   	EntityManager em= EMUtil.provideEntityManager();
		
	   	try {
	   		
	   		em.getTransaction().begin();
	   		
	   		em.persist(dpt);
	   		
	   		em.getTransaction().commit();
	   		
	   		System.out.println("Department Details inserted SuccessFully...");
	   		
	   	}catch (Exception e) {
			System.out.println("Not inserted..."); 
			
		}
	   	finally {
	   		em.close();
	   	}
	   		
		
	}

//********************************************************************************	
	
	@Override
	public void addEmployee(Employee emp) {
		
    EntityManager em= EMUtil.provideEntityManager();
		
	   	try {
	   		em.getTransaction().begin();
	   		
	   		em.persist(emp);
	   		
	   		em.getTransaction().commit();
	   		
	   		System.out.println("Employee Details inserted SuccessFully...");
	   		
	   	}catch(Exception e){
	   		System.out.println("Employee not inserted...");
	   	}
	   	finally {
	   		em.close();
	   	}
	   	
	}
	
//**********************************************************************************	

	@Override
	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException {
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Employee empID= em.find(Employee.class,empId);
			
			Department deptID= em.find(Department.class, deptId);
			
			if(empID==null) {
				throw new EmployeeException("Employee with ID "+empId+" dose not exist...");
			}
			
			if(deptID==null) {
				throw new DepartmentException("Department with ID "+deptId+" dose not exist...");
			}
			
			 em.getTransaction().begin();
			
		     empID.setDpt(deptID);
			
			em.getTransaction().commit();
			
			System.out.println("Employee successfully register in Department id "+deptId);
			
		}finally {
			em.close();
		}
		
		
		
		
		
	}

//***************************************************************************************************	
	
	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException {
		
		List<Employee> empList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT e FROM Employee e INNER JOIN e.dpt d WHERE d.deptName=:dname";
			
			Query q= em.createQuery(jpql);
			
			q.setParameter("dname",deptName);
			
			empList= q.getResultList();
			
			
			if(empList!=null) {
				return empList;
			}else {
				throw new EmployeeException("There is no employee in "+deptName+" department...");
			}
			
		}finally {
			em.close();
		}
		
		
		
		
		
	}

//***************************************************************************************************************	
	
	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException {
		Department dpt=null;
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Employee emp= em.find(Employee.class,empId);
			
			if(emp!=null) {
				
				String jpql="SELECT d FROM Department d Inner Join d.empList e WHERE e.empId=:empId";
				
				Query q= em.createQuery(jpql);
				
				q.setParameter("empId", emp.getEmpId());
				
				dpt=(Department)q.getSingleResult();
				
				return dpt;
				
			}else {
				throw new DepartmentException("Employee Id "+empId+" is not belong to any department...");
			}
			
		}finally {
			em.close();
		}
		
	}
	
	

}
