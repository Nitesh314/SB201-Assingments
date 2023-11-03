package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.EmployeeDao;
import com.masai.DAO.EmployeeDaoImpl;

public class GetAddressOfEmp {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the empId for Employee Address : ");
		int empId=sc.nextInt();
		
		EmployeeDao edao=new EmployeeDaoImpl();
		
	   String res=edao.getAddressOfEmployee(empId);
	   
	   System.out.println(res);
		
		
	}
	
	
	

}
