package com.masai.utill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtill {
	
  private static EntityManagerFactory emf;
  
  static {
	  emf=Persistence.createEntityManagerFactory("Customer-Address-Unit");
  }
	
  public static EntityManager provideEntityManager() {
	  return emf.createEntityManager();
  }
	

}
