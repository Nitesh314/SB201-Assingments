package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.AccountDao;
import com.masai.DAO.AccountDaoImpl;
import com.masai.Entites.Account;

public class AccountFindeById {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Account Id : ");
		int id=sc.nextInt();
		
		AccountDao aDao=new AccountDaoImpl();
		
		Account ac=aDao.findById(id);
		
		if(ac==null) {
			System.out.println("Account not Exist...");
		}else {
			System.out.println("Account id : "+ac.getId()+"\nAccount Email : "+ac.getEmail()+"\nAddress : "+ac.getAddress()+"\nAvailable Balance : "+ac.getBalance()+"\n+****************************************************\n");
		}
		
		
		
	}

}
