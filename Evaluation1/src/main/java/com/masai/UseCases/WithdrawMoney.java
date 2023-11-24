package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.AccountDao;
import com.masai.DAO.AccountDaoImpl;

public class WithdrawMoney {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Account id : ");
		int id=sc.nextInt();
		
		System.out.print("Enter the Amount for withdraw : ");
	    double amount=sc.nextDouble();
	    
	    AccountDao aDao=new AccountDaoImpl();
	    
	    String res=aDao.withdraw(amount, id);
	    
	    System.out.println(res);
	    	
	}

}
