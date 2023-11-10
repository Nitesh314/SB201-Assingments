package com.masai.useCase;

import com.masai.dao.EmployeeDetailsDao;
import com.masai.dao.EmployeeDetailsDaoImp;
import com.masai.model.Address;
import com.masai.model.Employee;

public class InsertEmployeeDetailsUseCase {
	
	public static void main(String[] args) {
		
		
		Address adr1=new Address("Maharashtra","Borivali","401-211", "HOME");
		
		Address adr2=new Address("Maharashtra","Vasai","401-208", "OFFICE");
		
		
		Employee emp=new Employee();
		
		emp.setName("Ashish");
		emp.setHomeAddress(adr1);
        emp.setOfficeAddress(adr2);
        emp.setSalary(65000);
		
		EmployeeDetailsDao eDao=new EmployeeDetailsDaoImp();
		
		
		String msg= eDao.insertEmployeeDetails(emp);
		
		System.out.println(msg);
		
		
		
		
		
		
		
	}

}
