/** File: Utility.java
 * Author: Jeffrey Xu
 * Date: 8/04/2020
 * Email: jeffreyxu@tamu.edu
 * 
 * Description: Contains functions that can read an input file containing CSCE314Student
 * information and store the information into an ArrayList. Writes results to results.txt
 * and errors to ErrorLog.txt.  
 */

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Utility {
	
	public static boolean readFile(String filename, ArrayList<CSCE314Student> students) throws FileNotFoundException {
		try {
			// Open file and error file
			Scanner scan = new Scanner(new File(filename));
			scan.nextLine();
			
			PrintWriter error = new PrintWriter(new File("ErrorLog.txt"));
			
			int lineNumber = 0;
			
			while(scan.hasNextLine()) {
				// Split the line into tokens
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				// Initialize student member values and catch errors that may reside in the file
				int JavaKnowledge = 0;
				int section = 0;
				
				if(tokens[1].chars().allMatch(Character::isDigit)) {
					JavaKnowledge = Integer.parseInt(tokens[1]);
				} else {
					error.println("ERROR IN " + filename  + ", Line " + lineNumber + ": JavaKnowledge isn't numeric");
					continue;
				}
				
				if(tokens[5].length() >= 3) {
					if(tokens[5].substring(0, 3).chars().allMatch(Character::isDigit)) {
						section = Integer.parseInt(tokens[5].substring(0, 3));
					} else {
						error.println("ERROR IN " + filename  + ", Line " + lineNumber + ": Section isn't numeric");
						continue;
					}
				} else {
					error.println("ERROR IN " + filename + ", Line " + lineNumber + ": Section format isn't correct");
					continue;
				}
				// Initialize rank enum
				Rank rank;
				String r = tokens[7];
				if(r.equals("1")) {
					rank = Rank.Freshman;
				} else if(r.equals("2")) {
					rank = Rank.Sophomore;
				} else if(r.equals("3")) {
					rank = Rank.Junior;
				} else if(r.equals("4")) {
					rank = Rank.Senior;
				} else {
					error.println("ERROR IN " + filename + ", Line " + lineNumber + ": Rank is invalid");
					continue;
				}
				String UIN = tokens[6].substring(0, 10);
				String[] name = tokens[4].split(" ");
				// Add student to the ArrayList
				CSCE314Student student = new CSCE314Student(name[0], name[1], UIN, JavaKnowledge, section, rank);
				students.add(student);
				lineNumber++;
			}
			scan.close();
			error.close();
			
			return true;
		} catch(Exception e) {
			System.out.println("ERROR: FILENAME NOT FOUND");
			return false;
		}
	}
	
	public static boolean writeResults(ArrayList<CSCE314Student> students) {
		try {
			File outFile = new File("results.txt");
			PrintWriter out = new PrintWriter(outFile);
			
			for(int i = 0; i < students.size(); i++) {
				String partners = students.get(i).toString();
				
				// Write partners if the end of the list isn't reached and the sections of the two students are the same
				if(i + 1 == students.size()) {
					out.println(partners);
				} else if(students.get(i).getSection() == students.get(i + 1).getSection()) {
					i++;
					partners += " - " + students.get(i).toString().substring(6, students.get(i).toString().length());
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
