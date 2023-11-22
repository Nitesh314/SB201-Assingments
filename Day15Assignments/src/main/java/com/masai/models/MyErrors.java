package com.masai.models;

import java.time.LocalDateTime;

public class MyErrors {
	
	private LocalDateTime timeStamp;
	
	private String mag;
	
	private String details;
	
	public MyErrors() {
		// TODO Auto-generated constructor stub
	}

	public MyErrors(LocalDateTime timeStamp, String mag, String details) {
		super();
		this.timeStamp = timeStamp;
		this.mag = mag;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMag() {
		return mag;
	}

	public void setMag(String mag) {
		this.mag = mag;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
