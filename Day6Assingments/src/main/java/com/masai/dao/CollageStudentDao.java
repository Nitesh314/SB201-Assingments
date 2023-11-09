package com.masai.dao;

import java.util.List;

import com.masai.models.Collage;
import com.masai.models.Student;

public interface CollageStudentDao {
	
	public String insertCollageStudentDetails(Collage clg1,Collage clg2);
	
	public List<Student> getStudentDetailsBasedOnClgId(int clgId);
	
	public Collage getCollageDetailsBasedOnStuRoll(int stuRoll); 

}
