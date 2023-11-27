package com.masai.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.masai")
@PropertySource("appName.properties")
public class AppConfig {
	
	
	@Bean
	public Map<Student,Course> addStudentCourse(){
		
		Map<Student,Course> map=new HashMap<>();
		
		Student s1=new Student(1,"Nitesh","Nalasopara","ab@gmail.com",400);
		Student s2=new Student(2,"Ashish","Vasai","ac@gmail.com",500);
		Student s3=new Student(3,"Sandeep","Virar","acb@gmail.com",600);
		
		Course c1=new Course(101,"Java",4,6000);
		Course c2=new Course(102,"Hibernate",2,2000);
		Course c3=new Course(103,"MySql",3,4000);
		
		map.put(s1, c1);
		map.put(s2, c2);
		map.put(s3, c3);
	    
		
		return map;
		
	}
	
	@Bean
	public List<Student> addStudent(){
		
		List<Student> sList=new ArrayList<>();
		
		sList.add(new Student(4,"Ankit","Gu","ank@gmaiul.com",800));
		sList.add(new Student(5,"Aman","Nalasopara","am@gmaiul.com",700));
		sList.add(new Student(6,"jadu","Virar","jad@gmaiul.com",900));
		sList.add(new Student(7,"Pradyuman","Vasai","pra@gmaiul.com",850));
		sList.add(new Student(8,"Ravi","UP","rav@gmaiul.com",700));
		
		return sList;
	}

	

	
	
	
}
