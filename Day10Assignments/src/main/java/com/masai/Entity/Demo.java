package com.masai.Entity;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	
	private Map<Department,Employee> theMap;

	
	//Setter inject point
	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}
	
	
	public void myInit(){
		System.out.println("inside myInit method");
     }

	
	public void cleanUp(){
		System.out.println("inside cleanUp method");
	}
	
	public void showDetails(){
		System.out.println("inside showDetails of Demo class");
		
		//print all the details of all the employees department-wise.
		
		for (Map.Entry<Department, Employee> entry : theMap.entrySet()) {
            Department department = entry.getKey();
            Employee employee = entry.getValue();
            System.out.println("Department Details: " + department);
            System.out.println("Employee Details: " + employee);
		}
		
	}
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.Xml");
		
		Demo demo= ctx.getBean("demo",Demo.class);
		
		demo.showDetails();
		
	}
	
	
	
}
