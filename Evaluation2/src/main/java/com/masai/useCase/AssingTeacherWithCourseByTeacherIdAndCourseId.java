package com.masai.useCase;

import com.masai.dao.TrainingDao;
import com.masai.dao.TrainingDaoIml;
import com.masai.exception.CourseException;
import com.masai.exception.TeacherException;

public class AssingTeacherWithCourseByTeacherIdAndCourseId {
	
	public static void main(String[] args) {
		
		TrainingDao tDao=new TrainingDaoIml();
		
		try {
			
			//tDao.assignTeacherWithCourse(teacherID,courseId);
			
			tDao.assignTeacherWithCourse(1003, 104);
			
		} catch (TeacherException e) {
		    System.out.println(e.getMessage());
		} catch (CourseException e) {
			 System.out.println(e.getMessage());
		}
		
	}

}
