package com.masai;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service(value="city")
public class AllService {
	
	
	List<String> cities;
	
	@Autowired
	public void setCities(List<String> cities) {
		this.cities=cities;
	}

	@Autowired
    private Environment env; 
	
	
	@Autowired
	private List<Student> sList;
	
	
	
	
	
	


//	public void printCities() {
//		
//		cities.add(env.getProperty("city1"));
//		cities.add(env.getProperty("city2"));
//		cities.add(env.getProperty("city3"));
//		cities.add(env.getProperty("city4"));
//		cities.add(env.getProperty("city5"));
//		
//		System.out.println(cities);
//	}
	
//	@PostConstruct
//	public void initMethod() {
//		System.out.println("Application started...");
//	}
//	
//	@PreDestroy
//	public void destoryMethod() {
//		System.out.println("Application Ended...");
//	}
	
	public void printStudent() {
		
		
		
		sList.forEach(s->System.out.println("Student roll : "+s.getRoll()+"\nStudent name : "+s.getName()+"\nStudnet marks : "+s.getMarks()+"\n**********************"));
	}

}
