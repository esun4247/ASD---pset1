package pset1;
import java.util.List;

public class SimpleArrayList {
	private String[] baseArray;
	private static final int initCapacity = 1;
	private int size;
	
	public SimpleArrayList() {
		baseArray = new String[initCapacity];
		size = 0;
	}
	
	public SimpleArrayList(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + n);
		}
		baseArray= new String[n];
		size = 0;
	}
	
	public SimpleArrayList(List<String> l) {
		baseArray= l.stream().toArray(String[]::new);
		size = l.size();
	}
	
	public void add(int index, String s) {
		checkBounds(index, size, true);
		checkIndex();
		for(int i = baseArray.length-2; i > index-1; i--) {
			baseArray[i+1] = baseArray[i];
		}
		size++;
		baseArray[index] = s;
	}
	
	public boolean add(String s) {
		checkIndex();
		baseArray[size] = s;
		size++;
		return true;
	}
	
	public void clear() {
		for(int i = 0; i < size; i++) {
			baseArray[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(String s) {
		for(int i = 0; i < size; i++) {
			if(baseArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public String get(int index) {
		checkBounds(index,size,false);
		return baseArray[index];
	}
	
	public int indexOf(String s) {
		for(int i = 0; i < size; i++) {
			if(baseArray[i].equals(s)) {
				return i; 
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public String remove(int index) {
		checkBounds(index,size,false);
		String string = baseArray[index];
		for(int i = index; i < size-1; i++) {
			baseArray[i] = baseArray[i+1];
		}
		baseArray[size-1] = null;
		size--;
		return string;
	}
	
	public boolean remove(String s) {
		int index = indexOf(s);
		if(index != -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	public String set(int index, String s) {
		checkBounds(index,size,false);
		String tempString = baseArray[index];
		baseArray[index] = s; 
		return tempString;
	}
	
	public int size() {
		return size;
	}
	
	public void trimToSize() {
		String[] tempArray = new String[size];
		for(int i = 0; i < size; i++) {
			tempArray[i] = baseArray[i]; 
		}
		baseArray = tempArray;
	}
	
	public String toString() {
		String tempString = "[";
		for(int i = 0; i < size-1; i++) {
			tempString += baseArray[i];
			tempString += ", ";
		}
		if(size != 0) {
			tempString += baseArray[size-1];
		}
		tempString += "]";
		return tempString;
	}
	
	public int length() {
		return baseArray.length;
	}
		
	
	private void checkBounds(int index, int size, boolean alternative) {
		if(index < 0 || index >= size) {
			if(!alternative) {
				throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
			}else {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			}
		}
	}
	
	
	
	private void checkIndex() {
		if(size+1 > baseArray.length) {
			String[] tempString = new String[baseArray.length+initCapacity];
			for(int i = 0; i < baseArray.length; i++) {
				tempString[i] = baseArray[i];
			}
			baseArray = tempString;
		}
	}
	
}
	

