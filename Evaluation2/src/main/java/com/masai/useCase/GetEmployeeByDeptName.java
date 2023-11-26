package com.masai.useCase;

import java.util.List;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.models.Employee;

public class GetEmployeeByDeptName {
	
	public static void main(String[] args) {
		
		EmployeeDao eDao=new EmployeeDaoImpl();
		
		try {
			List<Employee> empList= eDao.getAllEmployeeWithDeptName("manufacture");
			
			empList.forEach(e->System.out.println("Department Name : "+e.getDpt().getDeptName()+"\nEmployee id : "+e.getEmpId()+"\nEmployee Name : "+e.getEmpName()+"\nEmployee Salary : "+e.getSalary()+"\nEmployee city : "+e.getAddress().getCity()+"\nEmployee State : "+e.getAddress().getState()+"\nEmployee PinCode : "+e.getAddress().getPincode()+"\n*******************************************"));
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
