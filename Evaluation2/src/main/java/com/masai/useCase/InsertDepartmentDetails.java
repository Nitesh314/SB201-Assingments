package com.masai.useCase;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.models.Department;

public class InsertDepartmentDetails {
	
	public static void main(String[] args) {
		
		Department dpt=new Department();
		
		dpt.setDeptName("Manufacture");
		dpt.setLocation("Vasai");
		
		EmployeeDao eDao=new EmployeeDaoImpl();
		
		eDao.addDepartment(dpt);
		
		
		
	}

}
