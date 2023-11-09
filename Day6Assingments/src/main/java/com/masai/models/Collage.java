package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collage {
	@Id
	private int collageId;
	private String collageName;
	private String collageAddress;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "collage")
	List<Student> student=new ArrayList<Student>();
	
	public Collage() {
		// TODO Auto-generated constructor stub
	}

	public Collage(int collageId, String collageName, String collageAddress, List<Student> student) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
		this.collageAddress = collageAddress;
		this.student = student;
	}

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getCollageAddress() {
		return collageAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
	

}
