package com.masai.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Student {
	@Id
	private int StudentRoll;
	private String studentName;
	private String mobileNumber;
	private String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Collage collage;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int studentRoll, String studentName, String mobileNumber, String email, Collage collage) {
		super();
		StudentRoll = studentRoll;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.collage = collage;
	}

	public int getStudentRoll() {
		return StudentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		StudentRoll = studentRoll;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collage getCollage() {
		return collage;
	}

	public void setCollage(Collage collage) {
		this.collage = collage;
	}
	
	
	
	
}
