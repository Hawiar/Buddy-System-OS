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
	JPanel p2;
	JTextArea ta;
	private boolean startUsed = false; //Keep track of user's first time using start
	
	private int heightAdjustment = 28;
	private final int MEM_BLOCK_SCALE = 10; 
	private final int MEM_BLOCK_WIDTH = 192; 
	private final int MEM_BLOCK_WIDTH_ADJUST = 16;
	
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
	private static JTextField nameAdd = new JTextField();
	private static JTextField sizeBox = new JTextField();
	private static JTextField nameRemove = new JTextField();
	
	

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
		MemoryController controller = new MemoryController();
		
		frame = new JFrame("Memory Management System");
		contentPane = frame.getContentPane();
		
		frame.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		contentPane.add(p1, BorderLayout.WEST);
		contentPane.add(p2, BorderLayout.EAST);
		
		ta = new JTextArea();
		p1.add(ta);
		
		frame.pack();
		frame.setSize(700, 700);
		frame.setVisible(true);
		buttonBar.setLayout(new GridLayout (5,2));
		p2.add(buttonBar, BorderLayout.EAST);
		
		if (startUsed == false) //Checks if user has already read the instructions
		{
			p1.setVisible(false);
			p2.setVisible(false);
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
				p1.setVisible(true);
				p2.setVisible(true);
				populate();
				makeGrid();}
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
		buttonBar.add(nameAdd);
		buttonBar.add(sizeBox);
	}
	
	private void makeGrid()
	{
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.GRAY);
		p1.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH, 10 * MEM_BLOCK_SCALE));
		contentPane.add(p1, BorderLayout.WEST);
		
		//ta = new JTextArea("THIS IS A TEST STRING");
		//p1.add(ta);
	}
	
	private void populate()
	{
		addButtons();
		
	}
	
	private void add()
	{
		String name = nameAdd.getText();
		String size = sizeBox.getText();
		controller.add(name, size);
		
		
	}
	
	private void remove()
	{
		String name = nameRemove.getText();
		controller.remove(name);
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
