import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

import java.io.*;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class GUI extends Utility {

	private JFrame frame;
	JLabel lblNewLabel_1;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CSCE 314 Java Team Creator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(257, 13, 356, 54);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Filename:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 85, 766, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Results");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(61, 140, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblErrors = new JLabel("Errors");
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblErrors.setBounds(458, 140, 56, 16);
		frame.getContentPane().add(lblErrors);
		
		JButton btnGenerateTeams = new JButton("Generate Teams");
		btnGenerateTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					readFile(filename, teamMaker.teams);
					teamMaker.createTeams();
					teamMaker.writePartners();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGenerateTeams.setBounds(579, 480, 143, 40);
		frame.getContentPane().add(btnGenerateTeams);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 181, 336, 389);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(486, 181, 341, 204);
		frame.getContentPane().add(textArea_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmUploadFile = new JMenuItem("Upload File");
		mntmUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog = new FileDialog((JFrame)null, "Select File to Open");
			    dialog.setMode(FileDialog.LOAD);
			    dialog.setVisible(true);
			    filename = dialog.getFile();
			    lblNewLabel_1.setText("Filename: " + filename);
			    
			    System.out.println(filename + " selected");
			}
		});
		mnFile.add(mntmUploadFile);
		frame.setVisible(true);
	}
}
