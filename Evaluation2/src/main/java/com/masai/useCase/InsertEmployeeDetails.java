package com.masai.useCase;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.models.Address;
import com.masai.models.Employee;

public class InsertEmployeeDetails {
	
	public static void main(String[] args) {
		
		Employee emp=new Employee();
		
		emp.setEmpName("Jadu");
		emp.setSalary(100000);
		emp.setAddress(new Address(10,"Virar","Maharashtra","401-210"));
		
		EmployeeDao eDao=new EmployeeDaoImpl();
        
		eDao.addEmployee(emp);
		
	}

}
