package com.masai.useCase;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CollageStudentDao;
import com.masai.dao.CollageStudentDaoImpl;
import com.masai.models.Student;

public class GetStudentDetailsBasedOnClgId {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the collage id : ");
		
		int cid=sc.nextInt();
		
		CollageStudentDao csDao=new CollageStudentDaoImpl();
		
		List<Student> sList= csDao.getStudentDetailsBasedOnClgId(cid);
		
		if(sList.isEmpty()) {
			System.out.println("NO details available...");
		}else {
			sList.forEach(s->System.out.println("Student Roll : "+s.getStudentRoll()+"\nStudent Name : "+s.getStudentName()+"\nStudent Email : "+s.getEmail()+"\nStudent Mobile : "+s.getMobileNumber()+"\n**************************"));
		}
		
	}

}
