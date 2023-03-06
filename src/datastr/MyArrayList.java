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
			
			if (index == elementCounter) {
				add(newElement);
			}
			
			else {
				
				if (isFull()) {
					increaseSize();
				}
				
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
	
	public void delete(int index) throws Exception {
		if (isEmpty()) {
			throw (new Exception("Already empty"));
		}
		else {
			if ((0 <= index) && (index < elementCounter)) {
				for (int i = index; i < elementCounter; i++) {
					elements[i] = elements[i+1];
				}
				
				elements[elementCounter-1] = 0;
				
				elementCounter--;
			}
			else {
				throw (new Exception("Wrong index"));
			}
		}
		
	}
	
	public char getIndex(int index) {
		if((index >= 0) && (index < elementCounter)) {
			return elements[index];
		}
		else {
			return ' ';
		}
	}
	
	public boolean findElement(char element) {
		if (elementCounter > 0) {
			for (int i = 0; i < elementCounter; i++) {
				if (elements[i] == element) {
					return true;
				}
			}
		}
		return false;
	}
	
	public char[] getNext(char element) throws Exception {
		
		if (findElement(element)) {
			int elementCount = 0;
			
			for (int i = 0; i < elementCounter; i++) {
				if (element == elements[i]) {
					elementCount++;
				}
			}
			
			if(elements[elementCounter-1] == element) {
				elementCount--;
			}
			
			char[] nextElements = new char[elementCount];
			
			int index = 0;
			
			for (int i = 0; i < elementCounter-1; i++) {
				if (element == elements[i]) {
					nextElements[index] = elements[i+1];
					index++;
				}
			}
			
			return nextElements;
			
		}
		else {
			throw(new Exception("Input element not found"));
		}
	}
	
	
	public char[] sort(SortingType type) throws Exception{
		
		if(isEmpty()) {
			throw (new Exception("Already empty"));
		}
		else {
			
			char[] sortedArray = new char[elementCounter];
			
			for (int i = 0; i < elementCounter; i++) {
				sortedArray[i] = elements[i];
			}
			
			char temp = ' ';
			
			if(type == SortingType.ASC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter - 1; j++) {
						if (sortedArray[j] > sortedArray[j+1]) {
							temp = sortedArray[j];
							sortedArray[j] = sortedArray[j+1];
							sortedArray[j+1] = temp;
						}
					}
				}
				
			}
			else if(type == SortingType.DESC) {
				for(int i = 0; i < elementCounter; i++) {
					for(int j = 0; j < elementCounter - 1; j++) {
						if (sortedArray[j] < sortedArray[j+1]) {
							temp = sortedArray[j];
							sortedArray[j] = sortedArray[j+1];
							sortedArray[j+1] = temp;
						}
					}
				}
				
			}
			else {
				throw (new Exception("Wrong sorting type"));
			}
			
			return sortedArray;
		}
	
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.print("[ ]");
		}
		else {
			System.out.print("[ ");
			for (int i = 0; i < elementCounter - 1; i++) {
				System.out.print(elements[i] + ", ");
			}
			System.out.print(elements[elementCounter - 1]);
			System.out.print(" ]");
			System.out.println();
		}
		
		
	}
	
	public void clear() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = new char[arraySize];
	}
	
}
	

