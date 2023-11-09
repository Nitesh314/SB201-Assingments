package com.masai.useCase;

import java.util.Arrays;

import com.masai.dao.CustomerAddressDao;
import com.masai.dao.CustomerAddressDaoImpl;
import com.masai.models.Address;
import com.masai.models.Customer;


public class insertCustomerAddressDetails {
	
	public static void main(String[] args) {
		
	   Address a1=new Address("Maharashtra","Nalasopara","401-209","HOME");
	   
	   Address a2=new Address("GOA","Mumbai","601-209","OFFICE");
	   
       Address a3=new Address("Uttar-Pradesh","Kharagpur","805-605","HOME");
	   
	   Address a4=new Address("Madhya-Pradesh","PrayagRaj","901-250","OFFICE");
	   
	   
	   Customer c1=new Customer(1,"NItesh","739191", "As@gmail.com",Arrays.asList(a1,a2));
	   
	   Customer c2=new Customer(2,"Ashish","898374", "ms@gmail.com",Arrays.asList(a3,a4));
	   
	   CustomerAddressDao caDao=new CustomerAddressDaoImpl();
	   
	   String msg= caDao.insertCustomerAddressDetails(c1, c2);
	   
	   System.out.println(msg);
		
	}
	

}
