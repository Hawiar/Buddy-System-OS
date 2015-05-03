package memoryMgmtSystem;

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

	//Prints current memory
	public void print()
	{
		model.print();
	}
}
