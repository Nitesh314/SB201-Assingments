package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.AccountDao;
import com.masai.DAO.AccountDaoImpl;
import com.masai.Entites.Account;

public class AccountSave {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Account Id : ");
		int id=sc.nextInt();
		
		System.out.print("Enter the Email Id : ");
		String email=sc.next();
		
		System.out.print("Enter the Address : ");
	    String address=sc.next();
		
		System.out.print("Enter the account Balance : ");
	    double balance=sc.nextDouble();
		
		Account ac=new Account(id, email, address,balance);
		
		AccountDao aDao=new AccountDaoImpl();
	    String res=aDao.save(ac);
	    
	    System.out.println(res);
		
	}

}
