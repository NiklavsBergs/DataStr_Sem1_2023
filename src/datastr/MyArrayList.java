package datastr;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyArrayList() {
		elements = new char[arraySize];
	}
	
	public MyArrayList(int inputArraySize) {
		if (inputArraySize > 0){
			arraySize = inputArraySize;
		}
		elements = new char[arraySize];
	}
	
	public boolean isFull() {
		return elementCounter >= arraySize;
	}
}
