
package com.masai.useCase;


import java.util.Scanner;

import com.masai.dao.CollageStudentDao;
import com.masai.dao.CollageStudentDaoImpl;
import com.masai.models.Collage;


public class GetCollageDetailsBasedOnStuId {

   public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Studnet Roll : ");
		
		int sRoll=sc.nextInt();
		
		CollageStudentDao csDao=new CollageStudentDaoImpl();
		
		Collage clg= csDao.getCollageDetailsBasedOnStuRoll(sRoll);
		
		if(clg.equals(null)) {
			System.out.println("NO details available...");
		}else {
			System.out.println("Collage Id : "+clg.getCollageId()+"\nCollage Name : "+clg.getCollageName()+"\nCollage Address : "+clg.getCollageAddress());
		}
		
	}
	
	
	
	
}
