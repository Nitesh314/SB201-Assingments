package com.masai.useCase;

import java.util.List;

import com.masai.dao.EmployeessDao;
import com.masai.dao.EmployeessDaoImpl;
import com.masai.models.SalariedEmployee;

public class GetSalariedEmployeeDetails {
	
	public static void main(String[] args) {
		
		EmployeessDao eDao=new EmployeessDaoImpl();
		
		List<SalariedEmployee> seList= eDao.getSalariedEmployeesDetails();
		
		
		if(seList.isEmpty()) {
			System.out.println("No Employee....");
		}else {
			System.out.println("Salaried Employees Details");
			seList.forEach(s->System.out.println("\nEmployee Id : "+s.getEmpId()+"\nEmployee Name : "+s.getEmpName()+"\nEmployee Email : "+s.getEmail()+"\nEmployee Salary : "+s.getSalary()+"\n***************************************"));
		}
		
	}

}
