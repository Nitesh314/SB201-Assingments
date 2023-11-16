package com.masai;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CitiesUseCase {
	
	

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AllService cs= ctx.getBean("city",AllService.class);
		
		//cs.printCities();
		
		cs.printStudent();
		
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
