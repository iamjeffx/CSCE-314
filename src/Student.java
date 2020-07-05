
public class Student extends Person {
	String UIN;
	
	public Student() {
		super();
		UIN = "";
	}
	
	public Student(String firstName, String lastName, String UIN) {
		super(firstName, lastName);
		this.UIN = UIN;
	}
	
	public String getUIN() {
		return this.UIN;
	}
	
	public void setUIN(String UIN) {
		this.UIN = UIN;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + " (" + this.UIN + ")";
	}
}
