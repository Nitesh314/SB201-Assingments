package com.masai.models;

import javax.persistence.Entity;


@Entity
public class SalariedEmployee extends Employeess {
	
	private int salary;
	
	private String email;
	
    
	public SalariedEmployee() {
		// TODO Auto-generated constructor stub
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
 
}
