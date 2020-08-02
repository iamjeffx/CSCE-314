/** File: Student.java
 * Author: Jeffrey Xu
 * Date: 8/04/2020
 * Email: jeffreyxu@tamu.edu
 * 
 * Description: Student object definition; inherits from Person. Also includes the Rank enum.
 */

enum Rank {
	Freshman, Sophomore, Junior, Senior;
}


public class Student extends Person {
	String UIN;
	Rank rank;
	
	public Student() {
		super();
		UIN = "";
		rank = Rank.Freshman;
	}
	
	public Student(String firstName, String lastName, String UIN, Rank rank) {
		super(firstName, lastName);
		this.UIN = UIN;
		this.rank = rank;
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
