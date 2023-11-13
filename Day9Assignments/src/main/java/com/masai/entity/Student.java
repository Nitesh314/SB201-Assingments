package com.masai.entity;

public class Student {
	
	private int roll;
	private String mark;
	private int marks;
	
	
	public Student(int roll, String mark, int marks) {
		super();
		this.roll = roll;
		this.mark = mark;
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [roll=" + roll + ", mark=" + mark + ", marks=" + marks + "]";
	}
	
	


}
