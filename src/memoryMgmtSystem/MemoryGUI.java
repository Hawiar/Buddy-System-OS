 package memoryMgmtSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;


public class MemoryGUI {
	NewCore mem;
	JFrame frame;
	JMenuBar menubar;
	Container contentPane;
	JPanel p1;
	JTextArea ta;
	private boolean startUsed = false; //Keep track of user's first time using start
	
	//Below is the set of starting user instructions in HTML
	private static final String instructions = "<html><center><font color='red'>Welcome to our Buddy System!</font><br><br>"
    		+ "<h1>Please read the instructions below. Press 'Start' when you are ready to begin: </h1><br> "
    		+ "1. <font color='gray'><em> To add an item to memory press 'Add'</em> </font><br>"
    		+ "2. <font color='gray'><em> To remove an item from memory press 'Remove'</em> </font><br>"
    		+ "3. <font color='gray'><em> 'Free Space' indicates how much memory you have remaining</em> </font><br>"
    		+ "4. <font color='gray'><em> To reset your memory press 'Reset'</em> </font><br>"
    		+ "5. <font color='gray'><em> To quit the program, press 'Quit'</em> </font></center><br><br></html>";
	
	private static JPanel buttonBar = new JPanel(); //Holds all the main user buttons
	private static JPanel startBar = new JPanel(); //Holds start button
	private static JLabel instructionsLabel; //Used for instructional display
	private JLabel freeSpace; //Possible counter for free space left in memory, to be displayed at top of button bar
	
	
	

	public static void main(String[] args)
	{
		MemoryGUI MGUI = new MemoryGUI();
	}
	
	public MemoryGUI()
	{
		makeFrame();
	}
	
	public void makeFrame()
	{
		frame = new JFrame("Memory Management System");
		contentPane = frame.getContentPane();
		
		frame.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		//contentPane.add(p1, BorderLayout.CENTER);
		
		ta = new JTextArea();
		p1.add(ta);
		
		frame.pack();
		frame.setSize(700, 700);
		frame.setVisible(true);
		buttonBar.setLayout(new GridLayout (5,1));
		contentPane.add(buttonBar, BorderLayout.EAST);
		
		if (startUsed == false) //Checks if user has already read the instructions
		{
			startBar.setLayout(new GridLayout (6,4));
			instructionsLabel = new JLabel(instructions);
			contentPane.add(startBar, BorderLayout.CENTER);
			contentPane.add(instructionsLabel, BorderLayout.NORTH);
			instructionsLabel.setVisible(false);
			Start();
			
		}
	}

	/*
	 * The Start method provides the user with a basic set of instructions
	 * when they first start to use the program. A 'Start' button 
	 * is present once the user is prepared to being using the buddy
	 * sysem for memory management.
	 */
	private void Start()
	{
		instructionsLabel.setVisible(true);
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBar.setVisible(false);
				instructionsLabel.setVisible(false);
				startUsed = true;
				populate();}
        });
		
		startBar.add(start);
	}
	
	private  void addButtons()
	{
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();}
        });
		
		JButton remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();}
        });
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();}
        });
		
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();}
        });
		
		//Populate buttons
		//buttonBar.add(freeSpace);
		buttonBar.add(add);
		buttonBar.add(remove);
		buttonBar.add(reset);
		buttonBar.add(quit);
	}
	
	private void populate()
	{
		addButtons();
		
	}
	
	private void add()
	{
		
	}
	
	private void remove()
	{
	
	}
	
	private void reset()
	{
		frame.dispose();
		makeFrame();
	}
	
	private void quit() {
		System.exit(0); 
	}
	
}
