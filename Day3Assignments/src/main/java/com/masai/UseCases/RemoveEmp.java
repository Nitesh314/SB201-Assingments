package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.EmployeeDao;
import com.masai.DAO.EmployeeDaoImpl;

public class RemoveEmp {
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the employee Id : ");
		int empId=sc.nextInt();
		
		EmployeeDao edao=new EmployeeDaoImpl();
		
        boolean res=edao.deleteEmployee(empId);
		
		if(res==true) {
			System.out.println("Removed Succefully...");
		}else {
			System.out.println("Not removed....");
		}
		
	}

}
