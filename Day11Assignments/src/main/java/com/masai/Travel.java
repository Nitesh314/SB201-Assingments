package com.masai;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Travel {
	
   
	private String destination;
	
	@Autowired
	private Car car;
	
	@Autowired
	private Bike bike;
	
	

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("Application started...");
	}
	
	@PreDestroy
	public void destoryMethod() {
		System.out.println("Application Ended...");
	}
	
	
	public void journeyStart() {
		System.out.println("Journey Start to "+destination);
		car.startCar();
		bike.rideStart();
	}
	

}
