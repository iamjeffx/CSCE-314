import java.util.Comparator;

public class CSCE314Student extends Student {
	int JavaKnowledge;
	int section;
	
	public CSCE314Student() {
		super();
		JavaKnowledge = 0;
		section = 0;
	}
	
	public CSCE314Student(String firstName, String lastName, String UIN, int JavaKnowledge, int section) {
		super(firstName, lastName, UIN);
		this.JavaKnowledge = JavaKnowledge;
		this.section = section;
	}
	
	public int getJavaKnowledge() {
		return this.JavaKnowledge;
	}
	
	public int getSection() {
		return this.section;
	}
	
	public void setJavaKnowledge(int JavaKnowledge) {
		this.JavaKnowledge = JavaKnowledge;
	}
	
	public void setSection(int section) {
		this.section = section;
	}
	
	public String toString() {
		return this.section + " - " + this.firstName + " " + this.lastName + " (" + this.UIN + ") (" + this.JavaKnowledge + ")";
	}
}

