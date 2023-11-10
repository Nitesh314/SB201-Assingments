package com.masai.dao;

import java.util.List;

import com.masai.model.Course;
import com.masai.model.Student;

public interface StudentCourseDao {
	
	public String insertStudentInCourse(Student s);
	
	public List<Student> getStudentsEnrolledInCourse(int courseId);
	
	public List<Course> getCoursesEnrolledInStudent(int studentId);

}
