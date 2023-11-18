package com.masai.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;

@RestController
public class AppController {
	
	
	    @RequestMapping("/getEmployee")
		public Employee getEmployee() {
			
			Employee emp=new Employee(1,"Nitesh",15000,"Vasai");
			
			return emp;
			
		}
	    
	    @RequestMapping("/getEmployeeList")
		public List<Employee> getEmployeeList() {
			
			Employee emp1=new Employee(1,"Nitesh",15000,"Vasai");
			Employee emp2=new Employee(2,"Ashish",17000,"NSP");
			Employee emp3=new Employee(3,"Sandeep",18000,"Virar");
			Employee emp4=new Employee(4,"Jadu",52000,"Boiser");
			Employee emp5=new Employee(5,"Rohan",25000,"Chinchoti");
			
			return  Arrays.asList(emp1,emp2,emp3,emp4,emp5);
			
			
		}
	
	
	@RequestMapping("/hello")
	//@ResponseBody
	public String sayHello() {
		return "Welcome to Spring Boot"; //here it will be represented as raw data
	}
	

}
