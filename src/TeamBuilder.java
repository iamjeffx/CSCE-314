import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;

public class TeamBuilder extends Utility {
	ArrayList<CSCE314Student> teams;
	
	public TeamBuilder() {
		teams = new ArrayList<CSCE314Student>();
	}
	
	public void sortBySection() {
		Collections.sort(teams, new SortBySection());
	}
	
	public void sortByJavaKnowledge() {
		Collections.sort(teams, new SortByJavaKnowledge());
	}
	
	public int numberOfSections() {
		int numSections = 1;
		this.sortBySection();
		
		for(int i = 0; i < teams.size() - 1; i++) {
			if(teams.get(i).getSection() != teams.get(i + 1).getSection()) {
				numSections++;
			}
		}
		return numSections;
	}
	
	public int numberoOfStudents() {
		return this.teams.size();
	}
	
	public void createTeams() {
		this.sortByJavaKnowledge();
		
		for(int i = 0; i < this.teams.size(); i += 2) {
			CSCE314Student student1 = this.teams.get(i);
			CSCE314Student student2 = student1;
			boolean foundPartner = false;
			
			for(int j = this.teams.size() - 1; j >= 0; j--) {
				student2 = this.teams.get(j);
			
				if(student2 == student1) {
					break;
				} else if(student2.getSection() == student1.getSection()) {
					foundPartner = true;
					this.teams.remove(j);
					break;
				}
			}
			
			if(foundPartner)
				this.teams.add(i, student2);
			else {
				teams.remove(student1);
				teams.add(student1);
			}
		}
	}
	
	public void writePartners() {
		writeResults(this.teams);
	}
	
	public void outputTeams() {
		for(int i = 0; i < teams.size(); i++) {
			System.out.println(teams.get(i).toString());
		}
	}
}



class SortBySection implements Comparator<CSCE314Student>{

	@Override
	public int compare(CSCE314Student student1, CSCE314Student student2) {
		return student1.section - student2.section;
	}
	
}

class SortByJavaKnowledge implements Comparator<CSCE314Student> {
	
	@Override
	public int compare(CSCE314Student student1, CSCE314Student student2) {
		return student1.JavaKnowledge - student2.JavaKnowledge;
	}
}
