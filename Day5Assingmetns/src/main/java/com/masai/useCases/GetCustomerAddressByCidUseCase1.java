package com.masai.useCases;

import java.util.List;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.models.Address;

public class GetCustomerAddressByCidUseCase1 {
	
	
	public static void main(String[] args) {
		
		
		CustomerDao cDao=new CustomerDaoImpl();
		
	    List<Address> aList=cDao.getAllAddressOfCustomerByCid(1);
		
		if(aList.isEmpty()) {
			System.out.println("Record Not Found...");
		}else {
              
			aList.forEach(a->System.out.println("State : "+a.getState()+"\nCity : "+a.getCity()+"\n pinCode : "+a.getPinCode()+"\n Type : "+a.getType()+"\n*****************************"));
		}
		
		
	}

}
