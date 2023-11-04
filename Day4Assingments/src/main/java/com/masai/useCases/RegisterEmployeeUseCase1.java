package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.employeeDao;
import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;

public class RegisterEmployeeUseCase1 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the  Employee Id : ");
		int id=sc.nextInt();
		
		System.out.print("Enter the Employee Name : ");
		String name=sc.next();
		
		System.out.print("Enter the Employee Address : ");
	    String address=sc.next();
	    
	    System.out.print("Enter the Employee Salary : ");
	    double salary=sc.nextDouble();
	    
	    Employee employee =new Employee(id, name, address,salary);
	    
	    employeeDao eDao=new EmployeeDaoImpl();
	    
	    try {
		  Employee em=eDao.registerEmployee(employee);
		  
		  
		  
		  System.out.println( "*****************************************+"+"\n"
		  		             +"       || Registerd Employee Details ||     "+"\n"
		  		             +"                                        "+"\n"
		  		             +" Employee id  : "+em.getEmpid()       +"\n"
		  		             +" Employee name : "+em.getName()       +"\n"
		  		             +" Employee Address : "+em.getAddress()+"\n"
		  		             +" Employee Salary : "+em.getSalary()  +"\n"
		  		             +"                                       \n"
		  		             +"          || Register successfully Thank you ||   \n"
		  		             +"******************************************");
		  
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
