package memoryMgmtSystem;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class MemoryController {
	
	NewCore model = new NewCore();
	
	public MemoryController()
	{
		//NewCore model = new NewCore();
	}
	
	//User button click on Add, adds item to memory
	public void add(String name, int size)
	{
		MemoryObject mem = new MemoryObject(name, "add", size);
		model.add(mem);
	}
	
	//User button click on Remove, removes item from memory
	public void remove(String name)
	{
		model.removeOne(name);
	}
	
	//Used to check if an item exists in memory, if not the view throws an error window
	public boolean exists(String name)
	{
		if(model.exists(name) == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public ArrayList<MemoryObject> coreMemory()
	{
		ArrayList<MemoryObject> memory = model.getMemory();
		return memory;
	}
	
	public void random()
	{
		Random numRand = new Random();
		Random nameRand = new Random();
		Random rand = new Random();
		
		String[] names = { "Terminator", "Slicer","Ninja", "cow", "Robot", "littlegirl", "Apple","Mango","Peach","Banana","Orange","Grapes","Watermelon","Tomato",
				         "Joe", "Tom", "Hawiar", "Baliga", "OS", "a", "A", "B", "b", "C", "D", "c", "d", "e", "f", "g", "h", "E", "F", "G", "H",
				         "bad","easy","lol","Hurt","code","hate","kill","ice","fire","icecream","man","destroy","computer","book","dictionary","technology",
				         "power","thunder","controller","dexterity","keyboard","thunderous","blizzard","hazardous","algorithm","destruction","operation","assignment","despicable"};

		boolean choice = rand.nextBoolean();
		if(choice)
		{
			//pick a random size from 1-64
			int size = numRand.nextInt((64 - 1) + 1) + 1;
			String name = names[(int) (Math.random() * names.length)];
			add(name, size);
			//System.out.println(name + size);
		}
		else
		{	
			String name = names[(int) (Math.random() * names.length)];
			remove(name);
			//System.out.println(name);
		}
		
		
	}

	//Prints current memory
	public void print()
	{
		model.print();
	}
}
