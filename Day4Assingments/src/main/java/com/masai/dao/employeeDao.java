package com.masai.dao;

import com.masai.exceptions.EmployeeException;
import com.masai.models.Employee;

public interface employeeDao {
	
	public Employee registerEmployee(Employee employee)throws EmployeeException;
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public Employee deleteEmployeeById(int empId) throws EmployeeException;
	
	public Employee updateEmployee(Employee employee)throws EmployeeException;
	
	

}
