package com.masai.useCase;

import java.util.List;
import com.masai.dao.TrainingDao;
import com.masai.dao.TrainingDaoIml;
import com.masai.exception.CourseException;
import com.masai.models.Student;

public class GetAllStudentByCourseName {
	
	public static void main(String[] args) {
		
		TrainingDao tDao=new TrainingDaoIml();
		
		try {
			List<Student> sList= tDao.getAlltheStudentsByCourseName("java");
			
			if(sList.isEmpty()) {
				System.out.println("No data...");
			}else {
				sList.forEach(s->System.out.println("Student roll : "+s.getRoll()+"\nStudent Name : "+s.getName()+"\nStudent Email : "+s.getEmail()+"\nStudent Mobile : "+s.getMobile()+"\n******************************************"));
			}
			
			
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
