package com.masai.useCase;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;

public class RegisterEmployeeToDepartment {
    
	public static void main(String[] args) {
		
		EmployeeDao eDao=new EmployeeDaoImpl();
		
		try {
			eDao.registerEmployeeTODepartment(8,2);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
}
