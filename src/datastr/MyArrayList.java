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
	
	private void increaseSize() {
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
	}
	
	public void add(char newElement) {
		if (isFull()) {
			increaseSize();
		}
		elements[elementCounter] = newElement;
		elementCounter++;
		
	}
	
	public void add(char newElement, int index) throws Exception {
	
		if ((0 <= index) && (index <= elementCounter)) {
			
			if (isFull()) {
				increaseSize();
			}
			
			if (index == elementCounter) {
				add(newElement);
			}
			else {
				for (int i = elementCounter; i > index; i--) {
					elements[i] = elements[i-1];
				}
				elements[index] = newElement;
				elementCounter++;
			}
		}
		else {
			throw (new Exception("Wrong index"));
		}
		
	}
	
	public void deleteIndex(int index) throws Exception {
		
		if ((0 <= index) && (index < elementCounter)) {
			for (int i = index; i < elementCounter; i++) {
				elements[i] = elements[i+1];
			}
			
			elementCounter--;
		}
		else {
			throw (new Exception("Wrong index"));
		}
		
	}
	
	public char getIndex(char[] elements, int index) {
		if((index >= 0) && (index < elementCounter)) {
			return elements[index];
		}
		else {
			return ' ';
		}
	}
	
	public int findElement(char[] elements, char element) {
		if (elementCounter > 0) {
			for (int i = 0; i < elementCounter; i++) {
				if (elements[i] == element) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int getNext(int index) {
		if((index >= 0) && (index < elementCounter-1)) {
			return elements[index+1];
		}
		else {
			return ' ';
		}
	}
	
	
}
	

