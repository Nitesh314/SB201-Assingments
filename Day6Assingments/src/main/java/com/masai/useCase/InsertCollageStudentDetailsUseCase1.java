package com.masai.useCase;

import java.util.Arrays;

import com.masai.dao.CollageStudentDao;
import com.masai.dao.CollageStudentDaoImpl;
import com.masai.models.Collage;
import com.masai.models.Student;

public class InsertCollageStudentDetailsUseCase1 {
	
	public static void main(String[] args) {
		
		Collage clg=new Collage();
		
		Collage clg1=new Collage();
		
		//we not set student details;
		clg.setCollageId(1);
		clg.setCollageName("Vidya Varidhi Collage");
		clg.setCollageAddress("Santosh bhuvan");
		
		clg1.setCollageId(2);
		clg1.setCollageName("Sopara Collage");
		clg1.setCollageAddress("Nalasopara");
		
		//set student details;
		
		Student stu=new Student(101, "Nitesh","7391912483","a@gmail.com", clg);		
		Student stu1=new Student(102, "Ashish","8983748674","b@gmail.com", clg);
		Student stu2=new Student(103, "Sandeep","7710817246","c@gmail.com", clg);
		Student stu3=new Student(104, "Jadu","1234567890","d@gmail.com", clg);
		
		
		Student stu4=new Student(1001, "Nitesh","7391912483","a@gmail.com", clg1);		
		Student stu5=new Student(1002, "Ashish","8983748674","b@gmail.com", clg1);
		Student stu6=new Student(1003, "Sandeep","7710817246","c@gmail.com", clg1);
		Student stu7=new Student(1004, "Jadu","1234567890","d@gmail.com", clg1);
		
		//inserting student details in clg
		
		clg.setStudent(Arrays.asList(stu,stu1,stu2,stu3));
		
		clg1.setStudent(Arrays.asList(stu4,stu5,stu6,stu7));
		
		CollageStudentDao csDao=new CollageStudentDaoImpl();
		
		String msg= csDao.insertCollageStudentDetails(clg, clg1);
		
		System.out.println(msg);
		
		
	}
	

}
