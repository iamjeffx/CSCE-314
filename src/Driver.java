import java.io.FileNotFoundException;

public class Driver extends TeamBuilder {
	public static void main(String[] args) throws FileNotFoundException {
		TeamBuilder TeamMaker = new TeamBuilder();
		readFile("data.csv", TeamMaker.teams);
		
		TeamMaker.sortByJavaKnowledge();
		TeamMaker.sortBySection();
		TeamMaker.outputTeams();
	}
}
