package com.masai.useCase;

import com.masai.dao.EmployeessDao;
import com.masai.dao.EmployeessDaoImpl;
import com.masai.models.ContractualEmployee;

public class AddContractualEmployeeDetails {
	
	public static void main(String[] args) {
		
		ContractualEmployee ce=new ContractualEmployee();
		
		ce.setEmpName("Gautam");
		ce.setMobileNumber("1111111111");
		ce.setNoOfWorkingDays(18);
		ce.setCostOfPerDay(300);
		
		EmployeessDao eDao=new EmployeessDaoImpl();
		
		String msg= eDao.addContractualEmployee(ce);
		
		System.out.println(msg);
		
		
	}

}
