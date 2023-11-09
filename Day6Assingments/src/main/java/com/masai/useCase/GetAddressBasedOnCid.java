package com.masai.useCase;

import java.util.List;

import com.masai.dao.CustomerAddressDao;
import com.masai.dao.CustomerAddressDaoImpl;
import com.masai.models.Address;

public class GetAddressBasedOnCid {
	
	public static void main(String[] args) {
		
		CustomerAddressDao caDao=new CustomerAddressDaoImpl();
		
		List<Address> ad= caDao.getCustomerAddressesBasedOnCid(1);
		
		ad.forEach(a->System.out.println("State : "+a.getState()+"\nCity : "+a.getCity()+"\nPin-Code : "+a.getPincode()+"\nType : "+a.getType()+"\n*******************************************"));
	}

}
