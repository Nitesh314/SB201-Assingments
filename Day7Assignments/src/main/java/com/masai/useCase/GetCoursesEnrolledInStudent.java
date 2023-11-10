package com.masai.useCase;

import java.util.List;

import com.masai.dao.StudentCourseDao;
import com.masai.dao.StudentCourseDaoImpl;
import com.masai.model.Course;

public class GetCoursesEnrolledInStudent {
	
	public static void main(String[] args) {
		
		StudentCourseDao csDao=new StudentCourseDaoImpl();
		
		List<Course> cList= csDao.getCoursesEnrolledInStudent(12);
		
		if(cList!=null) {
			cList.forEach(c->System.out.println("Course Id : "+c.getCourseId()+"\nCourse Name : "+c.getCourseName()+"\nCourse Duration : "+c.getDuration()+"\nCourse Fees : "+c.getFee()+"\n**************************************"));
		}else {
			System.out.println("Course not Enrolled Studnet...");
		}
		
	}

}
