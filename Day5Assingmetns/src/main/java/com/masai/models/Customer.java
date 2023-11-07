package com.masai.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private String mobileNumber;
	private String emial;
	
	@Embedded
	@ElementCollection
	@JoinTable(name = "emp_adr",joinColumns = @JoinColumn(name="customer_id"))
	List<Address> addresses;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String mobileNumber, String emial, List<Address> addresses) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emial = emial;
		this.addresses = addresses;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmial() {
		return emial;
	}


	public void setEmial(String emial) {
		this.emial = emial;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	
	
	

}
