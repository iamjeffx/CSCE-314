
public abstract class Person {
	String firstName;
	String lastName;
	
	public Person() {
		firstName = "";
		lastName = "";
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}
