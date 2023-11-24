package com.masai.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.Entites.Account;

public class AccountDaoImpl implements AccountDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
	EntityManager em=emf.createEntityManager();

	@Override
	public Account findById(int id) {
		Account account =null;
		
	   account=em.find(Account.class,id);
	   
	   em.close();
		
	   return account;
	   
	}

	@Override
	public String save(Account account) {
        String msg="Account not Saved...";
		
        if(account !=null) {
        	em.getTransaction().begin();
        	
        	em.persist(account);
        	
        	em.getTransaction().commit();
        	
        	return msg="Account saved succefully...";
        }else {
        	return msg;
        }
      
		
	}

	@Override
	public String deleteAccountById(int id) {
		
		String msg="Account not deleted...";
		
	    Account account=em.find(Account.class,id);
	    
	    if(account !=null) {
        	em.getTransaction().begin();
        	
        	em.remove(account);
        	
        	em.getTransaction().commit();
        	
        	return msg="Account deleted succefully...";
        }else {
        	return msg;
        }
		
	}

	@Override
	public String withdraw(double amount, int accountId) {
		String msg="Insert correct data...";
		
	    Account account=em.find(Account.class,accountId);
	    
	    if(account!=null) {
	    	
	    	if(account.getBalance()>=amount) {
	    		
	    		  em.getTransaction().begin();
	    		  
		    	  account.setBalance(account.getBalance()-amount);
		    	  
		    	  em.getTransaction().commit();
		    	  
		    	  System.out.println("Available balance : "+account.getBalance());
		    	  
		    	   msg="\nAmmount withdraw succefully..."+"\n"
                        +"   THANK YOU  ";
		    	  
		    	}else {
		    	  return  msg="Insufficient Amount...";
		    	}
	    
	    }
		return msg;
	    
	}

	@Override
	public String deposit(double amount, int accountId) {
		String msg="Amount Not deposited....";
		
        Account account=em.find(Account.class,accountId);
	    
	    if(account !=null) {
	    	   
	    	  em.getTransaction().begin();
	    	
	    	  account.setBalance(account.getBalance()+amount);
	    	  
	    	  em.getTransaction().commit();
	    	  
	    	  System.out.println("Available balance : "+account.getBalance());
	    	  
	    	
	    	 msg="Ammount Deposited succefully..."+"\n"
	    	                                           +"   THANK YOU  ";
	    
	    }
	    	return msg;
	    
	}

}
