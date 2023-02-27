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
		return elementCounter == arraySize;
	}
	
	public boolean isEmpty() {
		return elementCounter == 0;
	}
	
	public int returnCount() {
		return elementCounter;
	}
	
	public char[] doubleSize() {
		int newSize;
		char[] newArray;
		if (elementCounter > 100) {
			newSize = (int) (arraySize * 1.5);
		}
		else {
			newSize = arraySize * 2;
		}
		newArray = new char[newSize];
		
		for (int i = 0; i < elementCounter; i++) {
			newArray[i] = elements[i];
		}
		
		return newArray;
	}
	
	public char[] addElementEnd{
		
	}
}
