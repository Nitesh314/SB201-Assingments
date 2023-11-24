package com.masai.UseCases;

import java.util.Scanner;

import com.masai.DAO.AccountDao;
import com.masai.DAO.AccountDaoImpl;

public class DeleteAccountById {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Account id for delete : ");
		int id=sc.nextInt();
		
		AccountDao aDao=new AccountDaoImpl();
		
		String res=aDao.deleteAccountById(id);
		
		System.out.println(res);
			
	}

}
