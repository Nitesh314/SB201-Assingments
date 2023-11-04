package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.employeeDao;
import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;


public class UpdateEmployeeDetailsUseCase1 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the details of employee for update..."+"\n");
		
		System.out.print("Enter the Employee Id for Update details of employee : ");
		int id=sc.nextInt();
		
		System.out.println();
		
		System.out.println("Enter the new Details of employee..."+"\n");
		
		System.out.print("Enter the  Employee name : ");
		String name=sc.next();
		
		System.out.print("Enter the Employee Address : ");
	    String address=sc.next();
	    
	    System.out.print("Enter the Employee Salary : ");
	    double salary=sc.nextDouble();
		
		Employee employee=new Employee(id, name, address, salary);
		
	    employeeDao eDao=new EmployeeDaoImpl();
	    
	   try {
	   Employee	em= eDao.updateEmployee(employee);
	   
	   if(em != null) {
		   System.out.println( "********************************************************"+"\n"
		             +"       || Updated Employee Details ||     "+"\n"
		             +"                                        "+"\n"
		             +" Employee id  : "+em.getEmpid()       +"\n"
		             +" Employee name : "+em.getName()       +"\n"
		             +" Employee Address : "+em.getAddress()+"\n"
		             +" Employee Salary : "+em.getSalary()  +"\n"
		             +"                                       \n"
		             +"          ||Employee Account updated succefully Thank you ||  \n"
		             +"************************************************************");
	   }
	   
	   
	   
	   
	} catch (EmployeeException e) {
		e.getMessage();
	}
		
	}

}
