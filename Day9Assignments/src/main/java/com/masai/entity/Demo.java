package com.masai.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Collage clg= ctx.getBean("collage",Collage.class);
		
		
		clg.showDetails();
		
		
	}

}
