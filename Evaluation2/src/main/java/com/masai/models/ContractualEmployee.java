package com.masai.models;

import javax.persistence.Entity;


@Entity
public class ContractualEmployee extends Employeess {
	
	private int noOfWorkingDays;
	private int costOfPerDay;
	private String mobileNumber;
	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}
	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}
	public int getCostOfPerDay() {
		return costOfPerDay;
	}
	public void setCostOfPerDay(int costOfPerDay) {
		this.costOfPerDay = costOfPerDay;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	

}
