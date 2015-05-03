package memoryMgmtSystem;

public class MemoryController {
	
	NewCore model = new NewCore();
	
	public MemoryController()
	{
		//NewCore model = new NewCore();
	}
	
	public void add(String name, int size)
	{
		MemoryObject mem = new MemoryObject(name, "add", size);
		model.add(mem);
	}
	
	public void remove(String name)
	{
		//MemoryObject mem = new MemoryObject(name, "remove", 8);
		model.removeOne(name);
	}

	public void print()
	{
		model.print();
	}
}
