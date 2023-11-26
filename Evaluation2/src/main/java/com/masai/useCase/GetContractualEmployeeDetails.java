package com.masai.useCase;

import java.util.List;

import com.masai.dao.EmployeessDao;
import com.masai.dao.EmployeessDaoImpl;
import com.masai.models.ContractualEmployee;


public class GetContractualEmployeeDetails {
	
	public static void main(String[] args) {
		
		
        EmployeessDao eDao=new EmployeessDaoImpl();
		
		List<ContractualEmployee> ceList= eDao.getContractualEmployeesDetails();
		
		
		if(ceList.isEmpty()) {
			System.out.println("No Employee....");
		}else {
			System.out.println("Contract Employees Details");
			ceList.forEach(c->System.out.println("\nEmployee Id : "+c.getEmpId()+"\nEmployee Name : "+c.getEmpName()+"\nEmployee MobileNumber : "+c.getMobileNumber()+"\nEmployee Number of Working Days : "+c.getNoOfWorkingDays()+"\nEmployee coset per day in rupees : "+c.getCostOfPerDay()+"\n***************************************"));
		}
		
	}

}
