package com.masai.useCases;

import java.util.Arrays;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.models.Address;
import com.masai.models.Customer;

public class SaveCustomerDetailsUseCase1 {
	
	public static void main(String[] args) {
		
		
		Address adr1=new Address("Maharashtra","Vasai","401208","HOME");
		Address adr2=new Address("Uttar-Pradesh","PraygRaj","501209","VILAGE");
		Address adr3=new Address("Maharashtra","Virar","401209","OFFICE");
		
		Address adr4=new Address("Maharashtra","Pune","208401","OFFICE");
		Address adr5=new Address("Uttar-Khand","Ujjan","505405","VILAGE");
		Address adr6=new Address("Maharashtra","Vasai","401208","HOME");
		
		
		
		Customer customer1=new Customer();
		
		customer1.setName("Nitesh");
		customer1.setMobileNumber("739191248");
		customer1.setEmial("nsshukla315@gmial.com");
		customer1.setAddresses(Arrays.asList(adr1,adr2,adr3));
		
		
        Customer customer2=new Customer();
		
		customer2.setName("Ashish");
		customer2.setMobileNumber("8983748674");
		customer2.setEmial("ashishYadav314@gmial.com");
		customer2.setAddresses(Arrays.asList(adr4,adr5,adr6));
		
		
		CustomerDao cDao=new CustomerDaoImpl();
		
		String res=cDao.saveCustomerDetails(customer1, customer2);
		
		System.out.println(res);
		
		
		
	}

}
