package com.masai.useCases;

import java.util.Scanner;

import com.masai.dao.EmployeeDaoImpl;
import com.masai.dao.employeeDao;
import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;

public class GetEmployeeByIdUseCase1 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Get the Employee Details...");
		System.out.print("Enter the  Employee Id : ");
		int id=sc.nextInt();
		
		employeeDao eDao=new EmployeeDaoImpl();
		
	    try {
			Employee em=eDao.getEmployeeById(id);
			
			 System.out.println( "*****************************************+"+"\n"
  		             +"       || Employee Details ||     "+"\n"
  		             +"                                        "+"\n"
  		             +" Employee id  : "+em.getEmpid()       +"\n"
  		             +" Employee name : "+em.getName()       +"\n"
  		             +" Employee Address : "+em.getAddress()+"\n"
  		             +" Employee Salary : "+em.getSalary()  +"\n"
  		             +"                                       \n"
  		             +"          || Thank you ||  \n"
  		             +"******************************************");
  
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
