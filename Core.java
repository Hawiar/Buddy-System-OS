package memoryMgmtSystem;
public class Core {
	private static String [] memory;
	private int numItems;
	private static int size;
	/**
	* Main method.
	**/
	public static void main (String args []) {
		new Core();
	}
	/**
	* Constructor, sets the size of the array to 32.
	**/
	public Core () {
		size = 32;
		memory = new String [size];
		numItems = 0;
	}
	/**
	* Creates the array used for the memory system. Originally sets every item in the array
	* to empty. Also uses different funtions that can be performed on the memory system.
	* Returns the array.
	**/
	public static Object [] startMemory (Object [] array) throws MemoryException {
		memory = new String [32];
		for (int i = 0; i < memory.length; i++) {
			memory[i] = "empty";
		}
		for (int i = 0; i < array.length; i++) {
			MemoryObject current = (MemoryObject) array [i];
			if (current == null) {
				;
			}
			else if (current.getFunction().equals("add")) {
				add(current);
			}
			else if (current.getFunction().equals("remove")) {
			remove(current);
			}
			else {
				throw new MemoryException("Function String Not Allowed.");
			}
		}
		return memory;
	}
	/**
	* Method used to add an object. Gets the size of the object and the position in which it will be inserted into.
	* If an item can not be added, a statement is printed to say there are no available spots.
	* If an item can be added, it is stored in the array in the available position.
	**/
	public static void add (MemoryObject item) {
		int thisSize = item.getSize();
		int [] position = findPosition(thisSize);
		if (position [0] == position [1]) {
			System.out.println("No available positions for object " + item.getName() + ".");
			return;
		}
		for (int i = position [0]; i < position [1]; i++) {
			memory [i] = item.getName();
		}
	}
	/**
	* Method used to remove an item from the array. Finds the size of the item specified to be removed,
	* based on its name, and finds its subsize of the item. The item is removed and the spot it was in
	* becomes empty.
	**/
	public static void remove (MemoryObject item) {
		int thisSize = item.getSize();
		String name = item.getName();
		int subSize = findSubSize(thisSize);
		for (int i = 0; i < memory.length; i += subSize) {
			if (memory [i].equals(name)) {
				for (int j = i; j < i + subSize; j++) {
					memory [j] = "empty";
				}
			}
		}
	}
	/**
	* Method that returns the subsize of a block used for storing an item in memory. As long as the subsize
	* is greater than 1, the subsize be be cut in half as long as the item size is still able to fit in the
	* block.
	**/
	public static int findSubSize (int value) {
		int subSize = memory.length;
		while (subSize > 1) {
			if (value < subSize && subSize / 2 > value) {
				subSize = subSize / 2;
			}
			else {
				return subSize;
			}
		}
		return 0;
	}
	/**
	* Finds a position to insert a value into. If an item can fit, it returns the position available
	* for insertion.
	**/
	public static int [] findPosition (int value) {
		int [] position = new int [2];
		int subSize = findSubSize(value);
		for (int i = 0; i < memory.length; i += subSize) {
			boolean canFit = true;
			for (int j = i; j < i + subSize; j++) {
				if (!memory[j].equals("empty")) {
				canFit = false;
				break;
				}
			}
			if (canFit == false) {
				;
			}
			else {
				position [0] = i;
				position [1] = i + subSize;
				return position;
			}
		}
		return position;
	}
}
