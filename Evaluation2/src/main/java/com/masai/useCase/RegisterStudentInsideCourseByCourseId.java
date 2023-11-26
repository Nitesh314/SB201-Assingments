package com.masai.useCase;

import com.masai.dao.TrainingDao;
import com.masai.dao.TrainingDaoIml;
import com.masai.exception.CourseException;
import com.masai.models.Student;

public class RegisterStudentInsideCourseByCourseId {
	
	public static void main(String[] args) {
		
		Student s=new Student();
		
		s.setRoll(4);
		s.setName("Jadu");
		s.setEmail("ja@Gmail.com");
		s.setMobile("0000000000");
		
		TrainingDao tDao=new TrainingDaoIml();
		
		try {
			tDao.registerStudent(s,101);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
				
		
		
	}
	
	

}
