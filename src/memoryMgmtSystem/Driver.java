package memoryMgmtSystem;

public class Driver {
	
	public static void run () 
	{
		NewCore model = new NewCore();
		MemoryGUI view = new MemoryGUI();
		MemoryController controller = new MemoryController();	
	}
	
	public static void main(String[] args)
	{
		run();
	}
}
