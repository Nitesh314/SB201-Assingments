package com.masai.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	private int courseId;
	private String courseName;
	private String duration;
	private int fee;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student>sList=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public Course(int courseId, String courseName, String duration, int fee, List<Student> sList, Teacher teacher) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.sList = sList;
		this.teacher = teacher;
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


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	public List<Student> getsList() {
		return sList;
	}


	public void setsList(List<Student> sList) {
		this.sList = sList;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	

}
