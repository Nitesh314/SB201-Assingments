package com.masai.useCase;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.models.Department;

public class GetDepartmentDetailsByEmployeeId {

	 public static void main(String[] args) {
		
		 EmployeeDao eDao=new EmployeeDaoImpl();
		 
		 try {
			Department dpt= eDao.getDepartmentDetailsByEmployeeId(6);
			
			System.out.println("Department Id : "+dpt.getDeptId()+"\nDepartment Name : "+dpt.getDeptName()+"\nDepartment Location : "+dpt.getLocation());
			
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
		 
	}
	
}
