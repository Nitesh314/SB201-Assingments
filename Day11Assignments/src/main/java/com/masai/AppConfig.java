package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.masai")
@PropertySource("cities.properties")
public class AppConfig {
	
	
	@Bean
	public List<String> cities(){
		
		List<String> cList=new ArrayList<>();
		
		return cList;
	}
	
	
	@Bean
	public List<Student> getStudent(){
		
		List<Student> sList=new ArrayList<>();
		
		sList.add(new Student(1,"Nitesh",800));
		sList.add(new Student(2,"Ashish",900));
		sList.add(new Student(3,"Sandeep",1000));
		sList.add(new Student(4,"Ankit",850));
		sList.add(new Student(5,"Pagala",900));
		
		
		return sList;
		
	}

}
