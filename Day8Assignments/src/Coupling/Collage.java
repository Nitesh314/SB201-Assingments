package Coupling;

public class Collage {
	
	private TeachingService teacher;
	
	private RegisterationService clerk;
	
	//we get two type of this value
	
	//1 constructor injection point
	
	public Collage(TeachingService teacher, RegisterationService clerk) {
		super();
		this.teacher = teacher;
		this.clerk = clerk;
	}
	
	//2 setter injection point
	
	public void setTeacher(TeachingService teacher) {
		this.teacher = teacher;
	}

	public void setClerk(RegisterationService clerk) {
		this.clerk = clerk;
	}
	
	
	
	public void doJob(){
		
		teacher.teaches();
		
		clerk.registerStudent();
		
		System.out.println("Job is started");
		}

	

	

}
