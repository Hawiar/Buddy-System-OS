package memoryMgmtSystem;
/**
* Exception to make sure the function trying to be performed can be executed.
**/
public class MemoryException extends RuntimeException {
public MemoryException (String s) {
super(s);
}
}
