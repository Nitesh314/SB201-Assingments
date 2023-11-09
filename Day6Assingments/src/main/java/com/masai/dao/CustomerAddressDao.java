package com.masai.dao;

import java.util.List;

import com.masai.models.Address;
import com.masai.models.Customer;

public interface CustomerAddressDao {
	
	public String insertCustomerAddressDetails(Customer c1,Customer c2 );
	
    public List<Address> getCustomerAddressesBasedOnCid(int cid);
	
	
}
