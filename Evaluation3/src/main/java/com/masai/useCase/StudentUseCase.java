package com.masai.useCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.bean.AppConfig;
import com.masai.studentService.StudentService;

public class StudentUseCase {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		StudentService sc= ctx.getBean(StudentService.class);
		
		sc.printList();
		
		sc.printMap();
		
		sc.printAppName();
	}

}
