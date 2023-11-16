package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TravelUseCase {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig2.class);
		
		Travel tr= ctx.getBean("travel",Travel.class);
		
		
		tr.setDestination("Mumbai");
		
		tr.journeyStart();
		
	     ((AnnotationConfigApplicationContext)ctx).close();
		
	}

}
