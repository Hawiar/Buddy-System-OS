package memoryMgmtSystem;

/*
 * class MemoryObject
 * The MemoryObject class stores information for a memory object.
 * 
 * Each memory object has 3 key components:
 * name = Object's name used for identifying the object in memory
 * function = the object's function in memory (add or remove)
 * size = how much space the object is going to take up in memory
 * 
 */
public class MemoryObject {

	private String name;
	private String function;
	private int size;
	
	public MemoryObject (String word, String fun, int num) {
		name = word;
		function = fun;
		size = num;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String word) {
		name = word;
	}
	
	public String getFunction () {
		return function;
	}
	
	public void setFunction (String fun) {
		function = fun;
	}
	
	public int getSize () {
		return size;
	}
	
	public void setSize (int num) {
		size = num;
	}
	
}
