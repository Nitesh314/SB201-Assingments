package com.masai.useCase;

import com.masai.dao.TrainingDao;
import com.masai.dao.TrainingDaoIml;
import com.masai.models.Course;

public class AddCourseDetails {
	
	public static void main(String[] args) {
		
		Course c=new Course();
		
		c.setCourseId(104);
		c.setCourseName("JavaScript");
		c.setDuration("6-Month");
		c.setFee(7000);
		
		TrainingDao tDao=new  TrainingDaoIml();
		
		tDao.addCourse(c);
		
		
		
		
	}

}
