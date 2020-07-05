import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Utility {
	
	public static boolean readFile(String filename, ArrayList<CSCE314Student> students) throws FileNotFoundException {
		try {
			Scanner scan = new Scanner(new File(filename));
			scan.nextLine();
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				int JavaKnowledge = Integer.parseInt(tokens[1]);
				int section = Integer.parseInt(tokens[5].substring(0, 3));
				
				String UIN = tokens[6].substring(0, 10);
				String[] name = tokens[4].split(" ");
				
				CSCE314Student student = new CSCE314Student(name[0], name[1], UIN, JavaKnowledge, section);
				
				students.add(student);
			}
			scan.close();
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean writeResults(ArrayList<CSCE314Student> students) {
		try {
			File outFile = new File("results.txt");
			PrintWriter out = new PrintWriter(outFile);
			
			for(int i = 0; i < students.size(); i++) {
				String partners = students.get(i).toString();
				
				if(i + 1 == students.size()) {
					out.println(partners);
				} else if(students.get(i).getSection() == students.get(i + 1).getSection()) {
					partners += " - " + students.get(i + 1).toString().substring(6, students.get(i + 1).toString().length());
					//partners += " - " + students.get(++i).toString();
					out.println(partners);
				} else {
					out.println(partners);
				}
			}
			
			out.close();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
