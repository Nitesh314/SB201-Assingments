package com.masai.Entity;

public class Department {
	
	private int deptId;
    private String deptName;
    private String location;
    
    //constructor inject point
	public Department(int deptId, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "]";
	}
    
    
	

}
