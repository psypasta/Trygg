
public class Student extends Person {
	
	private String course = " ";
	
	public Student() {
		
	}
	
	public Student(int i) {
		super(i);
	}
	public Student(int i, String c) {
		super(i);
		
		course = c;
	}
	
	String getCourse() {
		return course;
	}
}
