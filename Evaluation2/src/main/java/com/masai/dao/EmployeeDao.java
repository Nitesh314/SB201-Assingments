package com.masai.dao;

import java.util.List;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.models.Department;
import com.masai.models.Employee;

public interface EmployeeDao {
	
	public void addDepartment(Department dpt);
	
	public void addEmployee(Employee emp);
	
	public void registerEmployeeTODepartment(int empId, int deptId)throws EmployeeException, DepartmentException;
	
	public List<Employee> getAllEmployeeWithDeptName(String deptName)throws EmployeeException;
	
	public Department getDepartmentDetailsByEmployeeId(int empId)throws DepartmentException;

	


}
