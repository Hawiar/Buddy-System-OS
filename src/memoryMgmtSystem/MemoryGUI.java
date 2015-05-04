 package memoryMgmtSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class MemoryGUI extends JFrame implements ActionListener {
	MemoryController controller = new MemoryController();
	NewCore mem;
	JFrame frame;
	JMenuBar menubar;
	Container contentPane;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JTextArea t;
	float tempR;
	float tempG;
	float tempB;
	int currentSize= 0;
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
	private static JTextField nameAdd = new JTextField("Name");
	private static JTextField sizeBox = new JTextField("Size");
	private static JTextField nameRemove = new JTextField("Name");
	
	

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
		//MemoryController controller = new MemoryController();
		frame = new JFrame("Memory Management System");
		contentPane = frame.getContentPane();
		
		frame.setLayout(new BorderLayout());
		p1 = new JPanel();
		//p1.setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(64, 1));
		p2 = new JPanel();
		contentPane.add(p1, BorderLayout.WEST);
		contentPane.add(p2, BorderLayout.EAST);
		
		frame.pack();
		//frame.setSize(700, 700);
		frame.setSize(700, 800);
		frame.setVisible(true);
		buttonBar.setLayout(new GridLayout (8,2));
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
	
	//Populates the frame with buttons and textFields
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
		
		JButton print = new JButton("Print");
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();}
        });
		
		JButton random = new JButton("Random");
		random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				random();}
        }); 
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();}
        });
		
		
		
		//Populate buttons
		JLabel blank1 = new JLabel("    ");
		JLabel blank2 = new JLabel("    ");
		JLabel blank3 = new JLabel("    ");
		JLabel blank4 = new JLabel("    ");
		JLabel name1 = new JLabel("Name");
		JLabel name2 = new JLabel("Name");
		JLabel size = new JLabel("Size");
		buttonBar.add(name1);
		buttonBar.add(size);
		buttonBar.add(nameAdd);
		buttonBar.add(sizeBox);
		buttonBar.add(add);
		buttonBar.add(blank1);
		buttonBar.add(name2);
		buttonBar.add(blank4);
		buttonBar.add(nameRemove);
		buttonBar.add(blank2);
		buttonBar.add(remove);
		buttonBar.add(blank3);
		buttonBar.add(print);
		buttonBar.add(random);
		buttonBar.add(reset);
		buttonBar.add(quit);
	}
	
	private void makeGrid()
	{
		//p1 = new JPanel();
		//p1.setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(64,1));
		p1.setBackground(Color.WHITE);
		//p1.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH, 10 * MEM_BLOCK_SCALE));
		p1.setPreferredSize(new Dimension(MEM_BLOCK_WIDTH, MEM_BLOCK_SCALE));
		contentPane.add(p1, BorderLayout.WEST);
		
	}
	
	private void blocks(String s, int n){
		Random rnd = new Random();
		final float r = rnd.nextFloat() % 10;
		final float g = rnd.nextFloat() % 10;
		final float b = rnd.nextFloat() % 10;
		for(int i=0; i<n; i++){
			JTextArea co = new JTextArea(s);
			Color randomColor = new Color(r, g, b);
			co.setBackground(randomColor);
			System.out.println("its called");
			p1.add(co);
			p1.revalidate();
			p1.repaint();
		}
	}
	
	private void populate()
	{
		addButtons();
		makeGrid();
		
	}
	
	//User Add selection
	private void add()
	{
		String name = nameAdd.getText();
		String stringSize = sizeBox.getText();

		    //Item name must contain at least 1 character
			if(name.equals(""))
			{
			  JOptionPane.showMessageDialog(frame,
					    "Please enter a name containing at least 1 character",
					    "Name error",
					    JOptionPane.ERROR_MESSAGE);
			  nameAdd.setText("");
			  return;
			}
			//Checks if the name already exists in memory, asks for a new one if it does
			if(controller.exists(name))
			{
			  JOptionPane.showMessageDialog(frame,
					    "That name already exists, please choose another.",
					    "Name error",
					    JOptionPane.ERROR_MESSAGE);
			  nameAdd.setText("");
			  return;
			}
		//Checks to see if user entered a positive number for the size of the memory item	
		try
		{
		   int size = Integer.parseInt(stringSize);
		   if(size > 0)
	       {
			  controller.add(name, size);
			  nameAdd.setText("");
			  sizeBox.setText("");
	       }
		   else
		   {
			  JOptionPane.showMessageDialog(frame,
				    "Please enter a positive number in the 'Size' text field",
				    "Number error",
				    JOptionPane.ERROR_MESSAGE);
			  sizeBox.setText("");
		   }
	    }
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(frame,
				    "Please enter a number in the 'Size' text field",
				    "Number error",
				    JOptionPane.ERROR_MESSAGE);
			sizeBox.setText("");
		}		
	}
	
	//User remove selection
	private void remove()
	{
		String name = nameRemove.getText();
		if(controller.exists(name))
		{
		controller.remove(name);
		}
		else
		{
		JOptionPane.showMessageDialog(frame,
			    "The memory item " + nameRemove.getText() + " does not exist, try again." ,
			    "Nonexistant Error",
			    JOptionPane.ERROR_MESSAGE);
		}
		nameRemove.setText("");
	}
	
	private void print()
	{
		controller.print();
	}
	
	private void random()
	{
		controller.random();
	}
	
	private void reset()
	{
		frame.dispose();
		makeFrame();
	}
	
	private void quit() {
		System.exit(0); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
