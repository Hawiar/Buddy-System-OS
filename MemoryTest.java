package memoryMgmtSystem;

import org.junit.Assert;
import junit.framework.TestCase;

/*
 * The JUnit test class for Buddy Memory Management System
 */
public class MemoryTest extends TestCase {

	public static void test_add_function () {
		MemoryObject m = new MemoryObject("start", "add", 7);
		String[] result = new String[32];
		for (int i = 0; i < 8; i++) {
			result[i] = m.getName(); //Indices 0-7 are "start"
		}
		for (int i = 8; i < 32; i++) {
			result[i] = "empty"; //Indices 8-31 are "empty"
		}
		Object[] array = new Object[1];
		array[0] = m; 
		Assert.assertArrayEquals(result, Core.startMemory(array)); 
	}
	
	public static void test_add_and_remove_function () {
		MemoryObject m = new MemoryObject("start", "add", 7);
		MemoryObject n = new MemoryObject("middle", "add", 9);
		MemoryObject o = new MemoryObject("start", "remove", 7);
		String[] result = new String[32];
		for(int i = 0; i < 32; i++) {
			result[i] = "empty"; //Indices 0-31 are "empty"
		}
		for(int i = 16; i < 32; i++) {
			result[i] = "middle"; //Indices 16-31 are "middle"
		}
		Object[] array = new Object[3];
		array[0] = m;
		array[1] = n;
		array[2] = o;
		Assert.assertArrayEquals(result, Core.startMemory(array));
	}
	
}
