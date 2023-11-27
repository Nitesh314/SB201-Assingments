package com.masai.bean;

import java.util.Objects;

public class Course {
	
	private int courseId;
	private String courseName;
	private int duration;
	private int fee;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(int courseId, String courseName, int duration, int fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, duration, fee);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName) && duration == other.duration
				&& fee == other.fee;
	}
	
	
	
	
	

}
