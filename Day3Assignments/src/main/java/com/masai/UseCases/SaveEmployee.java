package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.EmployeeDao;
import com.masai.DAO.EmployeeDaoImpl;
import com.masai.Entites.Employee;

public class SaveEmployee {
	
    public static void main(String[] args) {
		
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.print("Enter the employee Id : ");
        int empId=sc.nextInt(); 
        
        System.out.print("Enter the employee name : ");
        String name=sc.next();  
        
        System.out.print("Enter the employee Address : ");
        String address=sc.next();  
        
        System.out.print("Enter the employee salary : ");
        int salary=sc.nextInt();  
    	 
        
        Employee emp=new Employee(empId, name, address, salary) ;
        
        EmployeeDao edao= new EmployeeDaoImpl();
        
        edao.save(emp);
	}
	

}
