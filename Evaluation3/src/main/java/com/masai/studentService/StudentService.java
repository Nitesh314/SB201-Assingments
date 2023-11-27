package com.masai.studentService;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.masai.bean.Course;
import com.masai.bean.Student;

@Service
public class StudentService {
	
	private Map<Student,Course> theMap;
	
	private List<Student>theList;
	
	@Value("${appName}")
	private String appName;
	
	
    @Autowired
	public void setTheMap(Map<Student, Course> theMap) {
		this.theMap = theMap;
	}

    @Autowired
	public void setTheList(List<Student> theList) {
		this.theList = theList;
	}

	
//**********************************************************************
	
	
	
	public void printMap(){
		
		for(Map.Entry<Student,Course> entry:theMap.entrySet()) {
			
			Student s=entry.getKey();
			Course c=entry.getValue();
			
			System.out.println("Studnet Details ");
			System.out.println("Student Roll : "+s.getRoll()+
					"\nStudent Name : "+s.getName()+
					"\nStudent Address : "+s.getAddress()+
					"\nStudent Email : "+s.getEmail()+
					"\nStudent Marks : "+s.getMarks()+
					"\n****************************************");
			
			System.out.println("Course Details");
			System.out.println("Course id  :"+c.getCourseId()+
					"\nCourse Name : "+c.getCourseName()+
					"\nCourse Duration : "+c.getDuration()+
					"\nCourse Fee : "+c.getFee()+
					"\n**********************************");
			
		}
		
    }
	
	public void printList(){
		//sort the List of Student according to the marks (make use of Lamda
		//expression).
		//print all the sorted Student Details
		
		Collections.sort(theList,(s1,s2)->s1.getMarks()<s2.getMarks()?+1:-1);
		
		theList.forEach(s->System.out.println("Student Roll : "+s.getRoll()+
				"\nStudent Name : "+s.getName()+
				"\nStudent Address : "+s.getAddress()+
				"\nStudent Email : "+s.getEmail()+
				"\nStudent Marks : "+s.getMarks()+
				"\n****************************************"));
	
	
	}
	
	
	public void printAppName(){
		
		System.out.println("Application Name : "+appName);
		
	}

	


}
