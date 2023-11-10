package com.masai.useCase;

import java.util.List;

import com.masai.dao.StudentCourseDao;
import com.masai.dao.StudentCourseDaoImpl;
import com.masai.model.Student;

public class getStudentsEnrolledInCourse {
	
	public static void main(String[] args) {
		
		StudentCourseDao scDao=new StudentCourseDaoImpl();
		
	    List<Student> sList= scDao.getStudentsEnrolledInCourse(11);
		
		if(sList!=null) {
			
			sList.forEach(s->System.out.println("Student Roll : "+s.getRoll()+"\nStudent Name : "+s.getName()+"\nStudent Email : "+s.getEmail()+"\nStudnet Mobile : "+s.getMobile()+"\n***************************"));
        	
	   }else {
		  
		   System.out.println("Student not Enrolled in the course...");
		  
	   }
		
	}

}
