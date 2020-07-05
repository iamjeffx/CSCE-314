import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Utility {
	
	public static boolean readFile(String filename, ArrayList<CSCE314Student> students) throws FileNotFoundException {
		try {
			Scanner scan = new Scanner(new File(filename));
			scan.nextLine();
			
			System.out.println("Loop initated");
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
			System.out.println("Loop completed");
			scan.close();
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean writeResults() {
		try {
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
