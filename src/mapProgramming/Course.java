package mapProgramming;

public class Course {

	private String courseCode; 
	private String name; 
	private int credits; 
	
	public Course(String courseCode, String name, int credits) {
		this.courseCode = courseCode; 
		this.name = name; 
		this.credits = credits; 
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	@Override
	public String toString() {
		return this.courseCode + ": " + this.name + ", " + this.credits + "cr"; 
	}
}
