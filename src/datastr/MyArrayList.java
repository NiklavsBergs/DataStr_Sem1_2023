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
	
	private char[] increaseSize(char[] elements) {
		int newSize;
		char[] newElements;
		if (elementCounter > 100) {
			newSize = (int) (arraySize * 1.5);
		}
		else {
			newSize = arraySize * 2;
		}
		newElements = new char[newSize];
		
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
		arraySize = newSize;
		
		return elements;
	}
	
	public char[] addElementEnd(char[] elements, char newElement) {
		elements[elementCounter] = newElement;
		elementCounter++;
		
		return elements;
	}
	
	public char[] addElementIndex(char[] elements, char newElement, int index) {
		if(elementCounter == 0) {
			elements[0] = newElement;
			elementCounter++;
		}
		else if ((0 <= index) && (index <= elementCounter)) {
			for (int i = elementCounter; i > index; i--) {
				elements[i] = elements[i-1];
			}
			elements[index] = newElement;
			elementCounter++;
		}
		
		return elements;
	}
	
	public char[] deleteElementIndex(char[] elements, int index) {
		
		if ((0 <= index) && (index < elementCounter)) {
			for (int i = index; i < elementCounter; i++) {
				elements[i] = elements[i+1];
			}
			
			elementCounter--;
		}
		
		return elements;
	}
}
	

