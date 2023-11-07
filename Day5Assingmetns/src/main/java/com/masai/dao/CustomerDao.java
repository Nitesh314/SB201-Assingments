package com.masai.dao;

import java.util.List;

import com.masai.models.Address;
import com.masai.models.Customer;



public interface CustomerDao {
	
	public String saveCustomerDetails(Customer customer1,Customer customer2 );
	
	public List<Address> getAllAddressOfCustomerByCid(int cid);

}
