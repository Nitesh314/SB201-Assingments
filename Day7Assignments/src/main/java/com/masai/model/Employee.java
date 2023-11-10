package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Employee extends Person {
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address homeAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Address officeAddress;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Employee(Address homeAddress, Address officeAddress, int salary) {
		super();
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
		this.salary = salary;
	}




	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	

}


