package com.masai.useCase;

import com.masai.dao.TrainingDao;
import com.masai.dao.TrainingDaoIml;
import com.masai.models.Teacher;

public class RegisterTeacher {
	
	public static void main(String[] args) {
		
		Teacher t=new Teacher();
		
		t.setTeacherId(1004);
		t.setTeacherName("Albert");
		t.setNoYearOfExperince(12);
		t.setEmail("alb@Gmail.com");
		
		TrainingDao tDao=new TrainingDaoIml();
		
		tDao.registerTeacher(t);
		
	}

}
