package com.masai.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
     
	@Id
	private int roll;
	private String name;
	private String email;
	private String mobile;  
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "sList")
	private List<Course>cList=new ArrayList<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String name, String email, String mobile, List<Course> cList) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.cList = cList;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Course> getcList() {
		return cList;
	}

	public void setcList(List<Course> cList) {
		this.cList = cList;
	}
	
	
	
}
