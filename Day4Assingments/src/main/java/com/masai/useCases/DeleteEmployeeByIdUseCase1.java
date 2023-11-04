package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.employeeDao;
import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;

public class DeleteEmployeeByIdUseCase1 {
	
	public static void main(String[] args) {
		
       Scanner sc=new Scanner(System.in);
		
		System.out.println("Get the Employee Details...");
		System.out.print("Enter the  Employee Id : ");
		int id=sc.nextInt();
		
		employeeDao eDao=new EmployeeDaoImpl();
		
	    try {
			Employee em=eDao.deleteEmployeeById(id);
			
			 System.out.println( "*****************************************+"+"\n"
  		             +"       || Deleted Employee Details ||     "+"\n"
  		             +"                                        "+"\n"
  		             +" Employee id  : "+em.getEmpid()       +"\n"
  		             +" Employee name : "+em.getName()       +"\n"
  		             +" Employee Address : "+em.getAddress()+"\n"
  		             +" Employee Salary : "+em.getSalary()  +"\n"
  		             +"                                       \n"
  		             +"          ||Employee Account deleted succefully Thank you ||  \n"
  		             +"******************************************");
  
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	
		
		
		
	}

}
