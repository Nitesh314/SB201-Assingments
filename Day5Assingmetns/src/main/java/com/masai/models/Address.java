package com.masai.models;

public class Address {
	
	private String state;
	private String city;
	private String pinCode;
	private String type;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String state, String city, String pinCode, String type) {
		super();
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
