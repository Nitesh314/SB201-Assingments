package com.masai.exceptions;

import java.time.LocalDateTime;

public class MyErrorDeatils {
	
	private LocalDateTime timeStamp;
	private String msg;
	private String details;
	
	
	public MyErrorDeatils() {
		// TODO Auto-generated constructor stub
	}


	public MyErrorDeatils(LocalDateTime timeStamp, String msg, String details) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.details = details;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
