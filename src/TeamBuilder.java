import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
			if(teams.get(i).section != teams.get(i + 1).section) {
				numSections++;
			}
		}
		return numSections;
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
