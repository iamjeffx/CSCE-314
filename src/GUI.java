/** File: GUI.java
 * Author: Jeffrey Xu
 * Date: 8/04/2020
 * Email: jeffreyxu@tamu.edu
 * 
 * Description: GUI class that implements user interface for creating 
 * partners and displaying errors.  
 */

import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenu;

import java.util.*;

public class GUI extends Utility {

	private JFrame frame;
	JTextPane resultOutput;
	JTextPane errorOutput;
	JLabel fileTitle;
	String filename;
	TeamBuilder teamMaker = new TeamBuilder();

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Set frame and layout
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Set title
		JLabel title = new JLabel("CSCE 314 Java Team Creator");
		title.setFont(new Font("Tahoma", Font.BOLD, 24));
		title.setBounds(257, 13, 356, 54);
		frame.getContentPane().add(title);
		
		// Set filename
		fileTitle = new JLabel("Filename:");
		fileTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fileTitle.setBounds(61, 85, 766, 31);
		frame.getContentPane().add(fileTitle);
		
		// Set title for results
		JLabel resultsTitle = new JLabel("Results");
		resultsTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resultsTitle.setBounds(61, 140, 56, 16);
		frame.getContentPane().add(resultsTitle);
		
		// Set title for errors
		JLabel errorTitle = new JLabel("Errors");
		errorTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorTitle.setBounds(503, 140, 56, 16);
		frame.getContentPane().add(errorTitle);
		
		// Generate teams button and add event listener
		JButton btnGenerateTeams = new JButton("Generate Teams");
		btnGenerateTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					readFile(filename, teamMaker.teams);
					teamMaker.createTeams();
					teamMaker.writePartners();
					String file_output = "";
					Scanner output = new Scanner(new File("results.txt"));
					while(output.hasNextLine()) {
						file_output += output.nextLine() + "\n";
					}
					resultOutput.setText(file_output);
					output.close();
					
				    String file_errors = "";
				    Scanner error = new Scanner(new File("ErrorLog.txt"));
				    while(error.hasNextLine()) {
				    	file_errors += error.nextLine() + "\n";
				    }
				    errorOutput.setText(file_errors);
				    error.close();
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateTeams.setBounds(579, 480, 143, 40);
		frame.getContentPane().add(btnGenerateTeams);
		
		// Initialize text panes for results and errors
		resultOutput = new JTextPane();
		errorOutput = new JTextPane();
		
		// Set scroll panes for results and errors
		JScrollPane scrollPane = new JScrollPane(resultOutput);
		scrollPane.setBounds(36, 162, 426, 425);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(errorOutput);
		scrollPane_1.setBounds(486, 162, 337, 261);
		frame.getContentPane().add(scrollPane_1);
		
		// Initialize menubar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// Add File option onto menubar
		JMenu fileSelect = new JMenu("File");
		menuBar.add(fileSelect);
		
		// Add Upload File button onto File option on the menubar
		JMenuItem mntmUploadFile = new JMenuItem("Upload File");
		mntmUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog = new FileDialog((JFrame)null, "Select File to Open");
			    dialog.setMode(FileDialog.LOAD);
			    dialog.setVisible(true);
			    filename = dialog.getFile();
			    fileTitle.setText("Filename: " + filename);
			}
		});
		fileSelect.add(mntmUploadFile);
		frame.setVisible(true);
	}
}
