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
	
	public static void main(String[] args){
		MemoryGUI MGUI = new MemoryGUI();
	}
	
	public MemoryGUI(){
		makeFrame();
	}
	
	public void makeFrame(){
		frame = new JFrame("Memory Management System");
		contentPane = frame.getContentPane();
		
		frame.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		contentPane.add(p1, BorderLayout.CENTER);
		
		ta = new JTextArea();
		p1.add(ta);
		
		frame.pack();
		frame.setSize(700, 700);
		frame.setVisible(true);
	}
}
