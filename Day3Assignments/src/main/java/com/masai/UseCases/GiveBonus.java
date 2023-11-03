package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.EmployeeDao;
import com.masai.DAO.EmployeeDaoImpl;

public class GiveBonus {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the employee Id : ");
		int empId=sc.nextInt();
		
		System.out.print("Enter the employee bonus : ");
		int bonus=sc.nextInt();
		
		EmployeeDao edao=new EmployeeDaoImpl();
		
		String res=edao.giveBonusToEmployee(empId, bonus);
				
		System.out.println(res);
		
	}

}
