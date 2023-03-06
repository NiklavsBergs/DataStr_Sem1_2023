package datastr;

public class MyArrayList<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyArrayList() {
		elements = (T[]) new Object[arraySize];
	}
	
	public MyArrayList(int inputArraySize) {
		if (inputArraySize > 0){
			arraySize = inputArraySize;
		}
		elements = (T[]) new Object[arraySize];
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
		
		if (elementCounter > 100) {
			newSize = (int) (arraySize * 1.5);
		}
		else {
			newSize = arraySize * 2;
		}
		
		T[] newElements = (T[]) new Object[newSize];
		
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
		arraySize = newSize;
	}
	
	public void add(T newElement) {
		if (isFull()) {
			increaseSize();
		}
		elements[elementCounter] = newElement;
		elementCounter++;
		
	}
	
	public void add(T newElement, int index) throws Exception {
	
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
				
				elements[elementCounter-1] = null;
				
				elementCounter--;
			}
			else {
				throw (new Exception("Wrong index"));
			}
		}
		
	}
	
	public T getIndex(int index) {
		if((index >= 0) && (index < elementCounter)) {
			return elements[index];
		}
		else {
			return null;
		}
	}
	
	public boolean findElement(T element) {
		if (elementCounter > 0) {
			for (int i = 0; i < elementCounter; i++) {
				if (elements[i].equals(element)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public T[] getNext(T element) throws Exception {
		
		if (findElement(element)) {
			int elementCount = 0;
			
			for (int i = 0; i < elementCounter; i++) {
				if (element.equals(elements[i])) {
					elementCount++;
				}
			}
			
			if(elements[elementCounter-1].equals(element)) {
				elementCount--;
			}
			
			T[] nextElements = (T[]) new Object[elementCount];
			
			int index = 0;
			
			for (int i = 0; i < elementCounter-1; i++) {
				if (element.equals(elements[i])) {
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
	
	
	public T[] sort(SortingType type) throws Exception{
		
		if(isEmpty()) {
			throw (new Exception("Already empty"));
		}
		else {
			
			T[] sortedArray = (T[]) new Object[elementCounter];
			
			for (int i = 0; i < elementCounter; i++) {
				sortedArray[i] = elements[i];
			}
			
			T temp = null;
			
			int sortVar = 1;
			
			if(type == SortingType.ASC) {
				sortVar = -1;
			}
			
			
			for(int i = 0; i < elementCounter; i++) {
				for(int j = 0; j < elementCounter - 1; j++) {
					//if (sortedArray[j] > sortedArray[j+1]) 
						
					if ( ((Comparable)sortedArray[j]).compareTo(sortedArray[j+1]) == sortVar){
						temp = sortedArray[j];
						sortedArray[j] = sortedArray[j+1];
						sortedArray[j+1] = temp;
					}
				}
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
		elements = (T[]) new Object[arraySize];
	}
	
}
	

