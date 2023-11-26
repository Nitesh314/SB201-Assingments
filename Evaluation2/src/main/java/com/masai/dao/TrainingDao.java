package com.masai.dao;

import java.util.List;
import com.masai.exception.CourseException;
import com.masai.exception.TeacherException;
import com.masai.models.Course;
import com.masai.models.Student;
import com.masai.models.Teacher;

public interface TrainingDao {

	public void addCourse(Course course);
	
	public void registerStudent(Student student,int courseId)throws CourseException;
    
	public void registerTeacher(Teacher teacher);
 
	public void assignTeacherWithCourse(int teacherId, int courseId) throws TeacherException, CourseException;

	public List<Student> getAlltheStudentsByCourseName(String courseName)throws CourseException;
	
	
}
