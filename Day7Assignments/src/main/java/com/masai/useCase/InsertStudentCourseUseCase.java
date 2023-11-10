package com.masai.useCase;

import java.util.Arrays;

import com.masai.dao.StudentCourseDao;
import com.masai.dao.StudentCourseDaoImpl;
import com.masai.model.Course;
import com.masai.model.Student;

public class InsertStudentCourseUseCase {
	
	public static void main(String[] args) {
		
		
	//set the student details without course	
		Student s1=new Student();
		
		s1.setName("Nitesh");
		s1.setEmail("Ab@gmail.com");
		s1.setMobile("7391912483");
		
        Student s2=new Student();
		
		s2.setName("Ashish");
		s2.setEmail("ns@gmail.com");
		s2.setMobile("8983748674");
		
		
        Student s3=new Student();
		
		s3.setName("Sandeep");
		s3.setEmail("sa@gmail.com");
		s3.setMobile("7710817246");
		
        Student s4=new Student();
		
		s4.setName("Pradyuman");
		s4.setEmail("pr@gmail.com");
		s4.setMobile("989030154");
		
	//set the course details without student
		
		Course c1=new Course();
		
		c1.setCourseName("Java");
		c1.setDuration("6-Month");
		c1.setFee(5000);
		
        Course c2=new Course();
		
		c2.setCourseName("Hibernate");
		c2.setDuration("3-Month");
		c2.setFee(4000);
		
		
        Course c3=new Course();
		
		c3.setCourseName("Spring");
		c3.setDuration("5-Month");
		c3.setFee(5000);
		
        Course c4=new Course();
		
		c4.setCourseName("MySQL");
		c4.setDuration("6-Month");
		c4.setFee(7000);
		
	//associate student with course
		
		s1.setCourseList(Arrays.asList(c1,c4,c2));
		s2.setCourseList(Arrays.asList(c1,c3,c2));
		s3.setCourseList(Arrays.asList(c1,c3));
		s4.setCourseList(Arrays.asList(c1,c4,c2,c3));
		
	
	//associate  course	with student
		
		c1.setStudentList(Arrays.asList(s1,s2,s3,s4));
		c2.setStudentList(Arrays.asList(s1,s2,s4));
		c3.setStudentList(Arrays.asList(s2,s3,s4));
		c4.setStudentList(Arrays.asList(s1,s4));
		
		
	    StudentCourseDao scDao=new StudentCourseDaoImpl();
	    
	    String msg=scDao.insertStudentInCourse(s1);
		
	    System.out.println(msg);
		
		
		
		
	}

}
