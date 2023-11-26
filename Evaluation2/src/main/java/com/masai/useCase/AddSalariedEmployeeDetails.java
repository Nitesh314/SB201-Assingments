package com.masai.useCase;

import com.masai.dao.EmployeessDao;
import com.masai.dao.EmployeessDaoImpl;
import com.masai.models.SalariedEmployee;

public class AddSalariedEmployeeDetails {
	
	public static void main(String[] args) {
		
		SalariedEmployee se=new SalariedEmployee();
		
		se.setEmpName("Jadu");
		se.setEmail("ja@Gmail.com");
		se.setSalary(10000);

		EmployeessDao eDao=new EmployeessDaoImpl();
		
		String msg= eDao.addSalariedEmployee(se);
		
		System.out.println(msg);
	}

}
